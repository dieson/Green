package com.dieson.green.pojo;

/**
 * @ClassName: Token
 * @Description: Token
 * @author: Dieson Zuo
 * @date: 2018年6月27日 下午12:33:35
 */
public class Token {
	//用户id
    private Integer userId;

    //随机生成的uuid
    private String token;

    public Token(Integer userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
