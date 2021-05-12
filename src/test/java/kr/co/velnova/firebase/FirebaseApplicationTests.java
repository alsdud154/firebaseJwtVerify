package kr.co.velnova.firebase;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import kr.co.velnova.firebase.jwt.JwtVerify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FirebaseApplicationTests {

	@Autowired
	private JwtVerify jwtVerify;

	@Test
	void auth() throws FirebaseAuthException {

		String authorization = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjUzNmRhZWFiZjhkZDY1ZDRkZTIxZTgyNGI4OTlhMWYzZGEyZjg5NTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcGlra2xlLWJmODZlIiwiYXVkIjoicGlra2xlLWJmODZlIiwiYXV0aF90aW1lIjoxNjIwODA2MTk0LCJ1c2VyX2lkIjoiYTNzdHMwQlNkS2FsRXY1WE5aQUE5OVNYMWx3MSIsInN1YiI6ImEzc3RzMEJTZEthbEV2NVhOWkFBOTlTWDFsdzEiLCJpYXQiOjE2MjA4MDYxOTUsImV4cCI6MTYyMDgwOTc5NSwiZW1haWwiOiJodW5AYWVyZ28uaW8iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsiaHVuQGFlcmdvLmlvIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.JEP7vXgqs2zoChvRUDq2hJ8b38SXaPSsa4JDMcP3Cu079UEczfWjElDYGhpdGG0yp32gVMbG-dC5kkvTkkZAuVUNqdcquJ-LwcPeaz6wZ0pkVm2cbiZviGtn6WbRqi65W-JqOhvGYIhoxf7kSu4vqmhRiifduOJU4Hzo-39LExoYltcvQdNHrKgCWUy61ACuK2JXm41_Dul6ybpe-DC7r-27h59FyvrrEuEvNBsnc0vIIGVHCCgw7wmKu-nX00Oa2pYLLYlOoX9X3BEkaTs62yWMhSc3pegvNircY3IwVKF-MtwTQ-ztDuE4z25NuUX6RlphQ0teZ95hvG7MiV-YyQ";

		String jwt = jwtVerify.getJwt(authorization);

		System.out.println("bearerToken = " + jwt);

		FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jwt);

		Map<String, Object> claims = decodedToken.getClaims();

		String uid = decodedToken.getUid();

		System.out.println("claims = " + claims);
		System.out.println("uid = " + uid);

	}

}
