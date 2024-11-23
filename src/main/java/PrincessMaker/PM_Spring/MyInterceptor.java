package PrincessMaker.PM_Spring;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    // 요청이 컨트롤러로 전달되기 전에 실행되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(request.getRequestURI() + " : Before handling the request");
        return true; // true를 반환하면 요청이 계속 진행됩니다.
    }

    // 컨트롤러가 처리한 후, 뷰가 렌더링되기 전에 실행되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println(response.getStatus() + " : After handling the request");
    }
}
