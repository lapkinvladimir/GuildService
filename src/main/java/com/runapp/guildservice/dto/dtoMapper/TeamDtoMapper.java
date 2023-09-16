package com.runapp.guildservice.dto.dtoMapper;

import com.runapp.guildservice.dto.request.TeamRequest;
import com.runapp.guildservice.dto.response.TeamResponse;
import com.runapp.guildservice.dto.response.UserTeamResponse;
import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.model.UserTeamModel;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TeamDtoMapper {

    public TeamModel toModel(TeamRequest teamRequest) {
        TeamModel teamModel = new TeamModel();
        teamModel.setTeamName(teamRequest.getTeamName());
        teamModel.setDescriptionTeam(teamRequest.getDescriptionTeam());
        teamModel.setCreateDate(LocalDateTime.now());
        teamModel.setTeamImageUrl("DEFAULT");
        teamModel.setRanking(0L);
        teamModel.setStoryId(teamRequest.getStoryId());
        teamModel.setMaximumPlayers(teamRequest.getMaximumPlayers());
        teamModel.setAdminId(teamRequest.getAdminId());
        return teamModel;
    }

    public TeamResponse toResponse(TeamModel teamModel) {
        TeamResponse teamResponse = new TeamResponse();
        teamResponse.setId(teamModel.getId());
        teamResponse.setTeamName(teamModel.getTeamName());
        teamResponse.setDescriptionTeam(teamModel.getDescriptionTeam());
        teamResponse.setCreateDate(teamModel.getCreateDate());
        teamResponse.setRanking(teamModel.getRanking());
        teamResponse.setTeamImageUrl(teamModel.getTeamImageUrl());
        teamResponse.setAdminId(teamModel.getAdminId());
        teamResponse.setStoryId(teamModel.getStoryId());
        teamResponse.setMaximumPlayers(teamModel.getMaximumPlayers());
        teamResponse.setUsers_in_team(teamModel.getUserTeamModelList());
        return teamResponse;
    }

}
