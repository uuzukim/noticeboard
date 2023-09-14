package kr.or.ddit.task;

import javax.inject.Inject;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class IntervalRetrieveJob {
	private int count;
	@Inject
	private ApplicationEventPublisher publisher;
	
	@Scheduled(fixedRate = 1000)
	public void retrieveJob() {
		log.info("1초 마다 반복 작업을 수행중");
		if(count++ % 5 ==0) {
			// 5번의 반복 작업 중 한번을 데이터가 변경된 경우로 가정함.
			publisher.publishEvent(new DataModifiedEvent("수정 데이터"));
		}
	}
}
