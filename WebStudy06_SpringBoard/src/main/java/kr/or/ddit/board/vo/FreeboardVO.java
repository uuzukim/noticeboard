package kr.or.ddit.board.vo;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.atch.vo.AtchFileVO;
import kr.or.ddit.validate.groups.AuthGroup;
import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="boNo")
public class FreeboardVO {
	private long rnum;
	@NotNull(groups = {UpdateGroup.class, AuthGroup.class, DeleteGroup.class})
	private Integer boNo;
	@NotBlank
	private String boTitle;
	@NotBlank
	private String boWriter;
	@NotBlank
	private String boIp;
	@Email
	private String boMail;
	@NotBlank(groups = {Default.class, AuthGroup.class, DeleteGroup.class})
	private String boPass;
	private String boContent;
	private LocalDate boDate;
	private Integer boHit;
	
	private MultipartFile[] boFiles;
	
	private Integer atchFileId;
	
	private AtchFileVO fileGroup; // has a
}

























