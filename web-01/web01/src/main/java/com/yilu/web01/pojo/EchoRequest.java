package com.yilu.web01.pojo;
/*
对应客户端发送的JSON
{
  "message": "hello"
}
 */
public class EchoRequest {

    private String message;

    public EchoRequest() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
