package kr.or.ddit.task;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class DataModifiedEvent {
	private final String modifiedData;
}
