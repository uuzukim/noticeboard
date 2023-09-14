package kr.or.ddit.atch.vo;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="atchFileId")
public class AtchFileVO {
	@NotBlank
	private int atchFileId;
	@NotBlank
	private LocalDate creatDt;
	private boolean useAt;
	
	private List<AtchFileDetailVO> detailList;
}
