package com.yukikyu.gpt.server.entity;

import com.yukikyu.gpt.server.constants.GPT3Model;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GPT3Request {

    // GPT-3 模型名称
    private GPT3Model model;

    // 输入的文本提示
    private String prompt;

    // 控制生成的文本的多样性，值越大则生成的文本越多样化
    private double temperature;

    // 生成的文本的最大长度
    private int maxTokens;

    // 指定生成文本时停止的条件
    private String stop;

    // 生成多个文本样本时的数量
    private int n;

    // 控制生成的文本中重复的程度
    private double frequencyPenalty;

    // 控制生成的文本中存在特定词汇的程度
    private double presencePenalty;

    // 生成多个文本样本时，选取最优文本的方式
    private int bestOf;

    // 控制 API 的返回结果是否流式传输
    private boolean stream;

    // 将对象转换为 Map 对象，便于传递给 GPT-3 API
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("model", model);
        map.put("prompt", prompt);
        map.put("temperature", temperature);
        map.put("max_tokens", maxTokens);
        map.put("stop", stop);
        map.put("n", n);
        map.put("frequency_penalty", frequencyPenalty);
        map.put("presence_penalty", presencePenalty);
        map.put("best_of", bestOf);
        map.put("stream", stream);
        return map;
    }

    // getters and setters
}
