package kr.co.velnova.firebase.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;

@Configuration
public class FirebaseConfig {

    @Value("${firebase.account-file-url}")
    private String firebaseAccountFileUrl;

    @Primary
    @Bean
    public void firebaseInit() throws IOException {

        GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(firebaseAccountFileUrl))
                .createScoped(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"));

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(credentials)
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }
    }
}
