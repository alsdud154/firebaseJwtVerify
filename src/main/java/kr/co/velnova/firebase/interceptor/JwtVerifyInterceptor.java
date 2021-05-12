package kr.co.velnova.firebase.interceptor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import kr.co.velnova.firebase.dto.CurrentUser;
import kr.co.velnova.firebase.jwt.JwtVerify;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class JwtVerifyInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final JwtVerify jwtVerify;

    public JwtVerifyInterceptor(JwtVerify jwtVerify) {
        this.jwtVerify = jwtVerify;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws FirebaseAuthException {

        String uri = request.getRequestURI();

        logger.debug("==================== START ====================");
        logger.debug("Request URI ===> " + uri);

        // jwt 추출
        String jwt = jwtVerify.getJwt(request.getHeader("Authorization"));

        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jwt);

        Map<String, Object> claims = decodedToken.getClaims();

        CurrentUser currentUser = CurrentUser.builder()
                .userId((String) claims.get("user_id"))
                .email((String) claims.get("email"))
                .build();

        request.setAttribute("currentUser", currentUser);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) {

        logger.debug("==================== END ======================");

    }
}
