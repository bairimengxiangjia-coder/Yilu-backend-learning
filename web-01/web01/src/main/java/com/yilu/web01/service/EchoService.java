package com.yilu.web01.service;

import com.yilu.web01.pojo.EchoResponse;
import org.springframework.stereotype.Service;

@Service
public class EchoService {
    public EchoResponse echo(String message){
        int length = message.length();
        EchoResponse echoResponse = new EchoResponse();

        // 将消息原文和计算出的长度放入响应对象。
        echoResponse.setMessage(message);
        echoResponse.setLength(length);

        return echoResponse;
    }
}
