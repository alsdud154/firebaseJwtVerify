package kr.co.velnova.firebase.util;

import kr.co.velnova.firebase.dto.CurrentUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {

    public static CurrentUser currentUser(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        return (CurrentUser) request.getAttribute("currentUser");
    }
}
