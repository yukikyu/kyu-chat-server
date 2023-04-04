package com.yukikyu.gpt.server.constants;

/**
 * GPT-3 模型枚举类，用于封装 GPT-3 模型名称及对应的模型 ID。
 */
public enum GPT3Model {
    
    // 枚举值列表
    
    DAVINCI("davinci"), // Davinci 模型
    CURIE("curie"), // Curie 模型
    BABBAGE("babbage"), // Babbage 模型
    ADA("ada"), // Ada 模型
    CURIE_INSTRUCT("curie-instruct-beta"), // Curie Instruct 模型
    DAVINCI_INSTRUCT("davinci-instruct-beta"), // Davinci Instruct 模型
    DAVINCI_CODEX("davinci-codex"), // Davinci Codex 模型
    DAVINCI_CODEX_INSTRUCT("davinci-codex-instruct-beta"), // Davinci Codex Instruct 模型
    CURIE_CODEX("curie-codex"), // Curie Codex 模型
    CURIE_CODEX_INSTRUCT("curie-codex-instruct-beta"); // Curie Codex Instruct 模型
    
    // 字段列表
    
    private final String modelId; // 模型 ID，使用 final 修饰，避免被修改

    /**
     * 构造函数，初始化模型 ID。
     *
     * @param modelId 模型 ID。
     */
    GPT3Model(String modelId) {
        this.modelId = modelId;
    }

    // 方法列表

    /**
     * 获取模型 ID。
     *
     * @return 模型 ID。
     */
    public String getModelId() {
        return modelId;
    }
}
