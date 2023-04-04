package com.yukikyu.gpt.server.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class GptResult {

    private String id;

    private String object;

    private long created;

    private String model;

    private List<Choices> choices;

    private Usage usage;

}