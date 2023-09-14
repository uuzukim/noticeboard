package kr.or.ddit.vo;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
@Data
@EqualsAndHashCode(of = "memId")
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"})
public class MemberVO implements Serializable{
	private long rnum;	
	@NotBlank(groups = {InsertGroup.class, DeleteGroup.class})
	private String memId;
	@NotBlank(groups = {Default.class, DeleteGroup.class})
	@Size(min = 4, max = 12, groups = {Default.class, DeleteGroup.class})
	@JsonIgnore
	private transient String memPass;
	@NotBlank(groups = InsertGroup.class)
	private String memName;
	@NotBlank(groups = InsertGroup.class)
	private transient String memRegno1;
	@NotBlank(groups = InsertGroup.class)
	private transient String memRegno2;
	
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime memBir;
	
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	@NotBlank
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate memMemorialday;
	
	private Integer memMileage;
	private boolean memDelete;
	
	private List<ProdVO> prodList; // has many
	
	private String memRole;
	
	private byte[] memImg;
	
	private MultipartFile memImage;
	public void setMemImage(MultipartFile memImage) throws IOException {
		if(!memImage.isEmpty()) {
			this.memImage = memImage;
			this.memImg = memImage.getBytes();
		}
	}
	
	public String getBase64Img() {
		if(memImg==null) {
			return null;
		}else {
			return Base64.getEncoder().encodeToString(memImg);
		}
	}
}




































