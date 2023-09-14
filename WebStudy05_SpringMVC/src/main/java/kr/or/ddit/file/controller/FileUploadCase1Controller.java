package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.file.dao.AtchFileDAO;
import kr.or.ddit.file.vo.AtchFileDetailVO;
import kr.or.ddit.file.vo.AtchFileVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileUploadCase1Controller {
	@Inject
	private AtchFileDAO atchDAO;
	
	@Value("#{appInfo.fsSavePath}")
	private Resource fsSaveRes;	
	@Value("#{appInfo.cpSavePath}")
	private Resource cpSaveRes;	
	@Value("#{appInfo.webSavePath}")
	private Resource webSaveRes;	
	
	@PostConstruct
	public void init() {
		log.info("저장 경로(file system) : {}", fsSaveRes.exists());
		log.info("저장 경로(class path) : {}", cpSaveRes.exists());
		log.info("저장 경로(web) : {}", webSaveRes.exists());
	}
	
	@GetMapping("/file/readFileGroup")
	public String getHandler(@RequestParam int atchFileId, Model model) {
		AtchFileVO fileGroup = atchDAO.selectAtchFileGroup(atchFileId);
		model.addAttribute("fileGroup", fileGroup);
		return "file/fileView";
	}
	
	
	@PostMapping("/file/uploadCase1")
	public String uploadCase1(
		@RequestParam String uploader
		, MultipartFile[] uploadFile
			
	) throws IOException {
		log.info("uploader : {}", uploader);
		log.info("upload file : {}", uploadFile);
		
		List<AtchFileDetailVO> detailList = new ArrayList<>();
		
		for(MultipartFile single  : uploadFile) {
			if(single.isEmpty()) continue;
			
			AtchFileDetailVO fileDetail = new AtchFileDetailVO(single);
			
			String saveName = fileDetail.getStreFileNm();
			File saveFile = new File(webSaveRes.getFile(), saveName);
			single.transferTo(saveFile); // 2진 데이터 저장
			fileDetail.setFileStreCours(saveFile.getCanonicalPath());
			
			detailList.add(fileDetail);
			
			log.info("저장된 파일 : {}", fileDetail.getFileStreCours());
			log.info("저장된 파일 원본명 : {}", fileDetail.getOrignlFileNm());
			log.info("저장된 파일 크기 : {}", fileDetail.getFileSize());
			log.info("저장된 파일 MIME : {}", fileDetail.getFileMime());
		}
		
		
		AtchFileVO fileGroup = new AtchFileVO();
		fileGroup.setDetailList(detailList);
		
		int cnt = atchDAO.insertAtchFileGroup(fileGroup);
		
		return "redirect:/file/readFileGroup?atchFileId="+fileGroup.getAtchFileId();
	}
}















