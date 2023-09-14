package kr.or.ddit.atch.vo;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"atchFileId", "fileSn"})
public class AtchFileDetailVO {
	private MultipartFile uploadFile;
	public AtchFileDetailVO(MultipartFile uploadFile) {
		super();
		this.uploadFile = uploadFile;
		
		this.orignlFileNm = uploadFile.getOriginalFilename();
		this.fileExtsn = FilenameUtils.getExtension(orignlFileNm);
		this.fileSize = uploadFile.getSize();
		this.fileMime = uploadFile.getContentType();
		
		this.streFileNm = UUID.randomUUID().toString();
	}
	
	@NotBlank
	private int atchFileId;
	@NotBlank
	private int fileSn;
	@NotBlank
	private String fileStreCours;
	@NotBlank
	private String streFileNm;
	private String orignlFileNm;
	@NotBlank
	private String fileExtsn;
	@ToString.Exclude
	private String fileCn;
	private long fileSize;
	private String fileMime;
}
