package kr.co.velnova.firebase.service;

import kr.co.velnova.firebase.dto.CurrentUser;
import kr.co.velnova.firebase.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FirebaseServiceImpl implements FirebaseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String contextTest() {
        CurrentUser currentUser = CommonUtil.currentUser();

        logger.debug("currentUser = " + currentUser);

        return "success";
    }
}
