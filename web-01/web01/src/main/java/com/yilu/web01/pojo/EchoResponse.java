package com.yilu.web01.pojo;
/*
对应服务器返回的JSON
{
  "message": "hello",
  "length": 5
}
*/
public class EchoResponse {

    private String message;

    private int length;

    public EchoResponse() {
    }

    public EchoResponse(String message, int length) {
        this.message = message;
        this.length = length;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}