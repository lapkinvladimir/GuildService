package com.runapp.guildservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private int id;

    private String taskTittle;

    private String taskDescription;

    private int taskRewardId;

    private String taskImageUrl;
}
