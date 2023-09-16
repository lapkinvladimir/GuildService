package com.runapp.guildservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamDeleteRequest {

    private String file_uri;
    private int team_id;
}
