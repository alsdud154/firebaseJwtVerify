package kr.co.velnova.firebase.config;

import kr.co.velnova.firebase.interceptor.JwtVerifyInterceptor;
import kr.co.velnova.firebase.jwt.JwtVerify;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    private final JwtVerify jwtVerify;

    public MvcConfiguration(JwtVerify jwtVerify) {
        this.jwtVerify = jwtVerify;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtVerifyInterceptor(jwtVerify));
    }


}
