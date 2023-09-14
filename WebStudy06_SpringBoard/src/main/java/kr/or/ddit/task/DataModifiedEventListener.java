package kr.or.ddit.task;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataModifiedEventListener {
	@EventListener(classes = DataModifiedEvent.class)
	public void eventHandler(DataModifiedEvent event) {
		log.info("데이터 갱신 이벤트 발생, event source : {}", event.getModifiedData());
	}
}
