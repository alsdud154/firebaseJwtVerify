# Firebase jwt 검증 및 CurrentUser 정보 추출

```
Interceptor에서 firebase sdk를 이용하여 jwt[header의 Authorization]를 검증한다. 
검증 후 HttpServletRequest Attribute에 CurrentUser 객체를 넣는다.
RequestContextHolder을 이용하여 Service 로직에서 CurrentUser를 추출하여 사용한다.
```
