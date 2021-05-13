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

		String authorization = "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjUzNmRhZWFiZjhkZDY1ZDRkZTIxZTgyNGI4OTlhMWYzZGEyZjg5NTgiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3NlY3VyZXRva2VuLmdvb2dsZS5jb20vcGlra2xlLWJmODZlIiwiYXVkIjoicGlra2xlLWJmODZlIiwiYXV0aF90aW1lIjoxNjIwODY3OTM3LCJ1c2VyX2lkIjoidGpJSmczRW1neWNWblVINmx0TFVrQkpWbTlJMiIsInN1YiI6InRqSUpnM0VtZ3ljVm5VSDZsdExVa0JKVm05STIiLCJpYXQiOjE2MjA4Njc5MzgsImV4cCI6MTYyMDg3MTUzOCwiZW1haWwiOiJodW5AYWVyZ28uaW8iLCJlbWFpbF92ZXJpZmllZCI6ZmFsc2UsImZpcmViYXNlIjp7ImlkZW50aXRpZXMiOnsiZW1haWwiOlsiaHVuQGFlcmdvLmlvIl19LCJzaWduX2luX3Byb3ZpZGVyIjoicGFzc3dvcmQifX0.VyaaVgppo5K90zFFBqbB_J_6t9f1Urbmm8G1FLKSVcy7NhupIEitqRtdHQsZwecrlCT7w22sD3Z2PhxSbL-SmIWJUkOZGkD4ZmUrvZKsgOGicvQJ6F1DfA7NYm-NHmm5m_IdhNW-HkmtHyyhvbXnksPj4emJbVQEkNJi7uh-3syMxuPYgP4MSJ3KtrdVJCRDCPlz3mv72rCRSQ6ttWC0HapzZz8dP9IV28khJX3ufu3d0en-tAhDOuh3_BTLTOAJvnP8Nqvcdzi2Vu3koraxbjVoFMQF_KmWIGsV_CjUXveShEBqfrQ5NgYVEpnYBV0HYzl-DtsTxEDzzeCHBCFJvw";

		String jwt = jwtVerify.getJwt(authorization);

		System.out.println("bearerToken = " + jwt);

		FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(jwt);

		Map<String, Object> claims = decodedToken.getClaims();

		String uid = decodedToken.getUid();

		System.out.println("claims = " + claims);
		System.out.println("uid = " + uid);

	}

}
