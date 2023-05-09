package com.kh.spring.common.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kh.spring.member.model.vo.Member;

@Component
@Aspect
public class BeforeTest {
	
	private Logger logger = LoggerFactory.getLogger(BeforeTest.class);
	
	// 사용자가 사용하고 있는 핸드폰 종류 -> LoggingInterceptor 클래스에서 복사해옴
	static String logMp[] = {"iphone", "ipad", "android", "blackberry", "opera mobi"};
	
	// joinPoint : advice가 적용될 수 있는 예비후보
	
	// joinPoint 인터페이스 : advice가 실제로 적용되는 클래스(Target Object(*Impl*))의 정보,
	//					   전달되는 매개변수, 메서드, 반환값, 예외등의 정보를 얻을 수 있는 메서드를 제공
	
	@Before("CommonPointcut.implPointcut()") // CommonPointcut 클래스 안에 정의해둔 implPointcut()함수 사용
	public void logService(JoinPoint jp) { /* JoinPoint 인터페이스는 항상 첫번째 매개변수로 작성되어야 한다. */
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n=================================== start ===================================\n");
		
		// start : 실행된 클래스명 - 실행된 메서드(...) 로 표시되도록 설정
		// 		   ex) start : BoardServiceImpl - selectBoardTypeList([])
		//				[] -> 반환값이 없음
		
		// JoinPoint -> getTargget() : AOP가 적용된 객체를 반환(XXXserviceImpl)
		sb.append("start : "+jp.getTarget().getClass().getSimpleName()+" - "); // 패키지명을 제외한 클래스명 알아옴
		
		// JoinPoint -> getSignature() : 수행되는 메서드 정보를 반환
		sb.append(jp.getSignature().getName());
		
		// JoinPoint -> getArgs() : 메서드 호출시 전달된 매개변수를 얻얼 수 있음 - 반환형 : 오브젝트계열의 배열
		sb.append("("+ Arrays.toString(jp.getArgs()) +")\n");
		
		// ip : web,mobile https://xxx...
		// HttpServletRequest 객체 얻어와야함(http, ip주소등을 얻기 위해서)
		// AOP실행시점에 예외발생시 -> 예외처리해줘야함
		try {
			// ★HttpServletRequest 얻어오는 방법 - 외우는게 좋음
			HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			
			// 접속된 장비가 무엇인지(웹인지, 모바일인지)
			String currentDevice = "web";
			String logUA = req.getHeader("user-agent").toLowerCase();
			for(String device : logMp) {
				if(logUA.indexOf(device) > -1) {
					currentDevice = "mobile";
					break;
				}
			}
			
			// Http+domain+port+uri 정보 얻어오기
			sb.append("ip : "+currentDevice+getIp(req)+" "+(req.isSecure() ? "https":"http")+"://"+
			req.getServerName()+req.getServerPort()+req.getRequestURI());
			
			// 접속 아이디
			// userId : 유저아이디
			Member loginUser = (Member)req.getSession().getAttribute("loginUser");
			if(loginUser != null) {
				sb.append("\nuserId : "+loginUser.getUserId());
			}
			
		} catch(Exception e) {
			sb.append(e.getMessage());
			sb.append("예외발생");
		}
		
		logger.info(sb.toString());
	}
	
	public String getIp(HttpServletRequest request){
		String ip = request.getHeader("X-Forwarded-For");
		
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}
