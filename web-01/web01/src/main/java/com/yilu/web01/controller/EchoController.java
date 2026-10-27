package com.yilu.web01.controller;

import com.yilu.web01.pojo.EchoRequest;
import com.yilu.web01.pojo.EchoResponse;
import com.yilu.web01.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//接收消息回显请求，并返回业务层的处理结果。
@RestController
/*这个注解表示这个类负责处理web请求，并将方法返回值写入响应体*/
public class EchoController {
    private final EchoService echoService;

    //Spring 通过构造方法传入 EchoService 对象。
    @Autowired
    public EchoController(EchoService echoService) {
        this.echoService = echoService;
    }

    @PostMapping(value = "/api/echo")
    public EchoResponse echo(@RequestBody EchoRequest echoRequest) {

        // 从请求对象中取出客户端提交的消息。
        String message = echoRequest.getMessage();
        // 将消息交给业务层处理。
        EchoResponse echoResponse = this.echoService.echo(message);
        // 返回响应对象，由 Spring 转换成 JSON。
        return echoResponse;

    }

}
