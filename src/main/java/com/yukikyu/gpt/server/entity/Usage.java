package com.yukikyu.gpt.server.entity;

import lombok.Data;

@Data
public class Usage {

    private int prompt_tokens;

    private int completion_tokens;

    private int total_tokens;

}