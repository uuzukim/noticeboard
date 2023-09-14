package kr.or.ddit.vo;

import lombok.Data;

/**
 * 단순 키워드 검색
 *
 */
@Data
public class SimpleCondition {
	private String searchType;
	private String searchWord;
}
