package com.eqs.security.jwt;

import com.eqs.AbstractTest;
import com.eqsdto.UserDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author june
 */
public class TokenProviderTest extends AbstractTest {

    @Autowired
    private TokenProvider tokenProvider;

    private String token;

    private UserDTO user;


    @Before
    public void setUp() throws Exception {
        user = new UserDTO();
        user.setAge(12);
        user.setId(1L);
        user.setUsername("周勇");
        token = tokenProvider.createToken(user,20000);
        Assert.assertNotNull(token);
        System.out.println("token："+token);
    }

    @Test
    public void createToken() throws Exception {
        String token2 = tokenProvider.createToken("user",1000*60*60*60*3);
        System.out.println("token2："+token2);
        Assert.assertNotNull(token2);
    }

    @Test
    public void parseToken() throws Exception {
        UserDTO user2 = tokenProvider.parseToken(token,UserDTO.class);
        Assert.assertNotNull(user2);
        Assert.assertEquals(user.getAge(),user2.getAge());
    }

    @Test
    public void validateToken() throws Exception {
        boolean flg = tokenProvider.validateToken(token);
        Assert.assertTrue(flg);
        //休息3秒，让token过期
//        Thread.sleep(3000);
//        boolean flg2 = tokenProvider.validateToken(token);
//        Assert.assertFalse(flg2);

        String myToken = "eyJhbGciOiJIUzUxMiJ9.eyJwYXlsb2FkIjoiXCJ1c2VyXCIiLCJleHAiOjE1MDE1Mzg1NTJ9.uso--xwXRPDbOU3P4O7XVttsGHWsFlUtaWY-UMaDi7NLtGNGlXnKGjt4bx6d1PZAY96pKx6vdvEOJ2ybidRieA";

        boolean flg3 = tokenProvider.validateToken(myToken);
        Assert.assertFalse(flg3);
    }

}