package com.yukikyu.gpt.server.controller;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.yukikyu.gpt.server.constants.GPT3Model;
import com.yukikyu.gpt.server.entity.GPT3Request;
import com.yukikyu.gpt.server.entity.GptResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author: yukikyu
 * @date: 2023-03-21 18:23
 */
@Slf4j
@CrossOrigin(origins = "*")
@RestController
public class GptClientController {

    @PostMapping("/chat")
    public String chat(@RequestBody String content) {
//        HashMap<String, Object> param = new HashMap<>();
//        param.put("model", "text-davinci-003");
//        param.put("prompt", content);
//        param.put("temperature", 0.5);
//        param.put("max_tokens", 1024);
//        param.put("top_p", 1.0);
//        param.put("frequency_penalty", 0.0);
//        param.put("presence_penalty", 0.0);
        GPT3Request gpt3Request = new GPT3Request();
        gpt3Request.setModel(GPT3Model.DAVINCI);
        gpt3Request.setPrompt(content);
        gpt3Request.setTemperature(0.5);
        gpt3Request.setMaxTokens(1024);
        gpt3Request.setFrequencyPenalty(0.0);
        gpt3Request.setPresencePenalty(0.0);

        HttpRequest httpRequest = HttpRequest.post("http://openai-sdk.yukikyu.com/v1/completions");
        httpRequest.header("Authorization", "Bearer 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");
        httpRequest.header("Content-Type", "application/json");

        log.info(httpRequest.toString());
        httpRequest.body(JSONUtil.toJsonStr(gpt3Request.toMap()), ContentType.JSON.getValue());

        HttpResponse httpResponse = httpRequest.execute();
        String body = httpResponse.body();

        log.info("body:{}", body);

        GptResult result = JSONUtil.toBean(body, GptResult.class);

        log.info("result:{}", result);

        return result.getChoices().get(0).getText();
    }

}
