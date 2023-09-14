package kr.or.ddit.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="lprodId")
public class LprodVO {
	@NotBlank
	private Integer lprodId;
	@NotBlank
	private String lprodGu;
	@NotBlank
	private String lprodNm;
}
