package kr.or.ddit.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	@Value("#{appInfo.permPath}")
	private Resource permPath;
	
	@RequestMapping("/index.do")
	public String index(HttpSession session) throws IOException {
		File newFile = new File(permPath.getFile(), UUID.randomUUID().toString());
		if(newFile.createNewFile()) {
			log.info("{} 파일 생성 성공", newFile);
		}else {
			log.info("{} 파일 생성 실패", newFile);
		}
		
		return "index";
	}
}
