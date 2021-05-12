package kr.co.velnova.firebase.controller;

import kr.co.velnova.firebase.service.FirebaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirebaseController {

    private final FirebaseService firebaseService;

    public FirebaseController(FirebaseService firebaseService) {
        this.firebaseService = firebaseService;
    }

    @GetMapping("/api/firebase")
    public String firebase(){

        return firebaseService.contextTest();
    }

}
