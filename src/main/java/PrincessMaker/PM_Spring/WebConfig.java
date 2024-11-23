package PrincessMaker.PM_Spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())  // MyInterceptor 클래스 등록
                .addPathPatterns("/**")  // 인터셉터가 적용될 URL 패턴
                .excludePathPatterns("/login", "/register");  // 특정 URL은 제외
    }
}
