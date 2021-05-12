# Firebase jwt 검증 및 CurrentUser 정보 추출

```
1. Interceptor에서 firebase sdk를 이용하여 jwt[header의 Authorization]를 검증한다. 
2. 검증 후 HttpServletRequest Attribute에 CurrentUser 객체를 넣는다.
3. RequestContextHolder을 이용하여 Service 로직에서 CurrentUser를 추출하여 사용한다.
```

```
1. jwt 토큰을 발행한다.  
2. jwt 검증 로직은 먼저 Interceptor에서 토큰 유효성을 체크한다.
3. jwt 검증을 성공했으면 aop를 이용하여 인자 값이 UserDTO가 있으면 jwt payload를 파싱하여 userID를 set 한다.
```
