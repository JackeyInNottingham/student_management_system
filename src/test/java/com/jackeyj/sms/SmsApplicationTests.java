package com.jackeyj.sms;

import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jackeyj.sms.common.utils.JWTUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
class SmsApplicationTests {

	@Test
	void contextLoads() {
		DecodedJWT verify = JWTUtils.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjoiYWRtaW4iLCJleHAiOjE2MTIwMjM1NjgsInVzZXJuYW1lIjoieGlhb2hvbmcifQ.D8BWLy9fgOhk7mEPrYS9xncUDPeHpo87zy6I4dxka0g");
		String username = verify.getClaim("username").asString();
		System.out.println(username);
	}

}
