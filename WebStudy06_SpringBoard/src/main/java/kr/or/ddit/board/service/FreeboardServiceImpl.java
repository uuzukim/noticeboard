package kr.or.ddit.board.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.service.AtchFileService;
import kr.or.ddit.atch.vo.AtchFileDetailVO;
import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.board.dao.FreeboardDAO;
import kr.or.ddit.board.vo.FreeboardVO;
import kr.or.ddit.board.vo.PaginationInfo;

@Service
public class FreeboardServiceImpl implements FreeboardService {
	@Inject
	private FreeboardDAO boardDAO;
	@Inject
	private PasswordEncoder passwordEncoder;
	
	@Inject
	private AtchFileService atchService;
	@Value("#{appInfo.atchPath}")
	private Resource atchPath;
	

	private void encryptBoard(FreeboardVO board) {
		String plain = board.getBoPass();
		String encoded = passwordEncoder.encode(plain);
		board.setBoPass(encoded);
	}
	
	private void processAtchFileGroup(FreeboardVO board) {
		MultipartFile[] boFiles = board.getBoFiles();
		if(boFiles==null) return;
		List<AtchFileDetailVO> detailList = new ArrayList<>();
		for(MultipartFile boFile : boFiles) {
			if(boFile.isEmpty()) continue;
			detailList.add( new AtchFileDetailVO(boFile) );
		}
		
		if(detailList.size()>0) {
			int atchFileId = Optional.ofNullable(board.getFileGroup())
									.map(fg->{
										try {
											atchService.addAtchFileGroup(fg.getAtchFileId(), detailList, atchPath);
											return fg.getAtchFileId();
										} catch (IOException e) {
											throw new RuntimeException(e);
										}
									}).orElseGet(()->{
										try {
											AtchFileVO group = new AtchFileVO();
											group.setDetailList(detailList);
											atchService.createAtchFileGroup(group, atchPath);
											return group.getAtchFileId();
										} catch (IOException e) {
											throw new RuntimeException(e);
										}
									});
			board.setAtchFileId(atchFileId);
			
		}
		
	}
	
	@Override
	public boolean createBoard(FreeboardVO board) {
		encryptBoard(board);
		processAtchFileGroup(board);
		return boardDAO.insertBoard(board) > 0;
	}


	@Override
	public List<FreeboardVO> retrieveBoardList(PaginationInfo paging) {
		long totalRecord = boardDAO.selectTotalRecord(paging);
		paging.setTotalRecord(totalRecord);
		return boardDAO.selectBoardList(paging);
	}

	@Override
	public FreeboardVO retrieveBoard(int boNo) {
		return boardDAO.selectBoard(boNo);
	}
	
	@Override
	public FreeboardVO boardAuthenticate(FreeboardVO input) {
		FreeboardVO saved =  boardDAO.selectBoard(input.getBoNo());
		if(passwordEncoder.matches(input.getBoPass(), saved.getBoPass())) {
			return saved;
		}else {
			return null;
		}
	}

	@Override
	public boolean modifyBoard(FreeboardVO board) {
		
		processAtchFileGroup(board);
		
		return boardDAO.updateBoard(board) > 0;
	}

	@Override
	public boolean removeBoard(FreeboardVO board) {
		FreeboardVO saved = boardAuthenticate(board);
		boolean success = false;
		if(saved!=null) {
			try {
				success = boardDAO.deleteBoard(board) > 0;
				if(saved.getAtchFileId()!=null) {
					success &= atchService.removeAtchFileGroup(saved.getAtchFileId(), atchPath);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return success;
	}
}








