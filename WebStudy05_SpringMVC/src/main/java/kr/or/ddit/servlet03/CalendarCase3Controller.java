package kr.or.ddit.servlet03;

import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 특정 년도와 월, 로케일, 시간대 파라미터를 이용해 달력을 처리하는 컨트롤러(Model2)
 *
 */
@Controller
@RequestMapping("/calendarCase3")

//@MultipartConfig
public class CalendarCase3Controller{
	
	@GetMapping
	public String doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		return "calendar/calendarCase3";
	}
	
	@PostMapping
	public String doPost(
		@RequestParam(required=false, defaultValue = "-1") int year
		, @RequestParam(required=false, defaultValue = "-1") int month
		, @RequestParam(required=false) String locale
		, Optional<String> zone
		, Model model
	){
		Locale loc = Optional.ofNullable(locale)
								.filter(l->!l.isEmpty())
								.map(lp->Locale.forLanguageTag(lp))
								.orElse(Locale.getDefault());
		
		ZoneId zoneId = zone.map(zp->ZoneId.of(zp))
							.orElse(ZoneId.systemDefault());

		LocalDate TODAY = LocalDate.now(zoneId);
		
		YearMonth targetYM = YearMonth.now(zoneId);
		if(year!=-1 && month!=-1){
			targetYM = YearMonth.of(year, month);
		}
		
		CalendarInfo infoVO = new CalendarInfo(targetYM, loc, zoneId);
		
		model.addAttribute("infoVO", infoVO);
		
		return "calendar/ajax/calView";
	}
}















