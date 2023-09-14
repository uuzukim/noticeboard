package kr.or.ddit.servlet03;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 특정 년도와 월, 로케일, 시간대 파라미터를 이용해 달력을 처리하는 컨트롤러(Model2)
 *
 */
@Controller
//@MultipartConfig
public class CalendarCase2Controller{
	
	@RequestMapping("/calendarCase2")
	public String service(
		@RequestParam(name="year", required = false, defaultValue = "-1") int yearValue
		, @RequestParam(name="month", required = false, defaultValue = "-1") int monthValue
		, @RequestParam(name="locale", required = false) Optional<String> localeParam
		, @RequestParam(name="zone", required = false) Optional<String> zoneParam
		, Model model
	){
		
		Locale locale = localeParam.map(lp->Locale.forLanguageTag(lp))
								.orElse(Locale.getDefault());
		
		ZoneId zone = zoneParam.map(zp->ZoneId.of(zp))
								.orElse(ZoneId.systemDefault());

		LocalDate TODAY = LocalDate.now(zone);
		
		YearMonth targetYM = YearMonth.now(zone);
		if(yearValue!=-1 && monthValue!=-1){
			targetYM = YearMonth.of(yearValue, monthValue);
		}
		
		CalendarInfo infoVO = new CalendarInfo(targetYM, locale, zone);
		
		model.addAttribute("infoVO", infoVO);
		
		return "calendar/ajax/calView";
	}
}















