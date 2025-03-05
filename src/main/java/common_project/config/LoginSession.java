package common_project.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class LoginSession {
    public static ArrayList<HttpSession> sessionList = new ArrayList<>();

    public LoginSession() {
        // HttpSession session = req.getSession(false) == null ? req.getSession() : req.getSession(false);

    }

    public void _init() {

    }

    /**
     * sessionList에 로그인 관련 세션이 있는지 확인하는 함수<br/>
     * 로그인 성공시 true를 반환
     * */
    public static boolean _loginStateCheck(int userNumber, HttpServletRequest req) {
        boolean state = false;
        boolean inSession = false;
        HttpSession session = null;
        if(sessionList.isEmpty()) {
            session = req.getSession();
            session.setAttribute("loginNumber", userNumber);
            sessionList.add(session);
            state = true;
        } else {
            // 동일한 아이디로 로그인이 되어있는 경우 세션을 삭제
            for(int index = 0; index < sessionList.size(); index++) {
                session = sessionList.get(index);
                if(userNumber == (Integer)session.getAttribute("loginNumber")) {
                    sessionList.remove(index);
                    inSession = true;
                }
            }
            // 세션 생성 및 추가
            session = req.getSession();
            session.setAttribute("loginNumber", userNumber);
            if(inSession) {
                sessionList.add(session);
            }
        }
        return state;
    }


}
