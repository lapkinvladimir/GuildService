package com.runapp.guildservice.dto.dtoMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.guildservice.dto.request.UserTeamRequest;
import com.runapp.guildservice.dto.response.UserTeamResponse;
import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.model.UserTeamModel;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserTeamDtoMapper.class})
@ExtendWith(SpringExtension.class)
class UserTeamDtoMapperDiffblueTest {
    @Autowired
    private UserTeamDtoMapper userTeamDtoMapper;

    /**
     * Method under test:
     * {@link UserTeamDtoMapper#toModel(UserTeamRequest, TeamModel)}
     */
    @Test
    void testToModel() {
        UserTeamRequest request = new UserTeamRequest(1, 1);

        TeamModel teamModel = new TeamModel();
        teamModel.setAdminId(1);
        teamModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        teamModel.setDescriptionTeam("Description Team");
        teamModel.setId(1);
        teamModel.setMaximumPlayers(3);
        teamModel.setRanking(1L);
        teamModel.setStoryId(1);
        teamModel.setTeamImageUrl("https://example.org/example");
        teamModel.setTeamName("Team Name");
        teamModel.setUserTeamModelList(new ArrayList<>());
        UserTeamModel actualToModelResult = userTeamDtoMapper.toModel(request, teamModel);
        assertEquals(1, actualToModelResult.getUserId());
        assertSame(teamModel, actualToModelResult.getTeam());
    }

    /**
     * Method under test:
     * {@link UserTeamDtoMapper#toModel(UserTeamRequest, TeamModel)}
     */
    @Test
    void testToModel2() {
        UserTeamRequest request = mock(UserTeamRequest.class);
        when(request.getUserId()).thenReturn(1);

        TeamModel teamModel = new TeamModel();
        teamModel.setAdminId(1);
        teamModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        teamModel.setDescriptionTeam("Description Team");
        teamModel.setId(1);
        teamModel.setMaximumPlayers(3);
        teamModel.setRanking(1L);
        teamModel.setStoryId(1);
        teamModel.setTeamImageUrl("https://example.org/example");
        teamModel.setTeamName("Team Name");
        teamModel.setUserTeamModelList(new ArrayList<>());
        UserTeamModel actualToModelResult = userTeamDtoMapper.toModel(request, teamModel);
        verify(request).getUserId();
        assertEquals(1, actualToModelResult.getUserId());
        assertSame(teamModel, actualToModelResult.getTeam());
    }

    /**
     * Method under test: {@link UserTeamDtoMapper#toResponse(UserTeamModel)}
     */
    @Test
    void testToResponse() {
        TeamModel team = new TeamModel();
        team.setAdminId(1);
        team.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team.setDescriptionTeam("Description Team");
        team.setId(1);
        team.setMaximumPlayers(3);
        team.setRanking(1L);
        team.setStoryId(1);
        team.setTeamImageUrl("https://example.org/example");
        team.setTeamName("Team Name");
        team.setUserTeamModelList(new ArrayList<>());

        UserTeamModel model = new UserTeamModel();
        model.setId(1);
        model.setTeam(team);
        model.setUserId(1);
        UserTeamResponse actualToResponseResult = userTeamDtoMapper.toResponse(model);
        assertEquals(1, actualToResponseResult.getId());
        assertEquals(1, actualToResponseResult.getTeamId());
        assertEquals(1, actualToResponseResult.getUserId());
    }

    /**
     * Method under test: {@link UserTeamDtoMapper#toResponse(UserTeamModel)}
     */
    @Test
    void testToResponse2() {
        TeamModel team = new TeamModel();
        team.setAdminId(1);
        team.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team.setDescriptionTeam("Description Team");
        team.setId(1);
        team.setMaximumPlayers(3);
        team.setRanking(1L);
        team.setStoryId(1);
        team.setTeamImageUrl("https://example.org/example");
        team.setTeamName("Team Name");
        team.setUserTeamModelList(new ArrayList<>());

        TeamModel teamModel = new TeamModel();
        teamModel.setAdminId(1);
        teamModel.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        teamModel.setDescriptionTeam("Description Team");
        teamModel.setId(1);
        teamModel.setMaximumPlayers(3);
        teamModel.setRanking(1L);
        teamModel.setStoryId(1);
        teamModel.setTeamImageUrl("https://example.org/example");
        teamModel.setTeamName("Team Name");
        teamModel.setUserTeamModelList(new ArrayList<>());
        UserTeamModel model = mock(UserTeamModel.class);
        when(model.getTeam()).thenReturn(teamModel);
        when(model.getId()).thenReturn(1);
        when(model.getUserId()).thenReturn(1);
        doNothing().when(model).setId(anyInt());
        doNothing().when(model).setTeam(Mockito.<TeamModel>any());
        doNothing().when(model).setUserId(anyInt());
        model.setId(1);
        model.setTeam(team);
        model.setUserId(1);
        UserTeamResponse actualToResponseResult = userTeamDtoMapper.toResponse(model);
        verify(model).getId();
        verify(model).getTeam();
        verify(model).getUserId();
        verify(model).setId(anyInt());
        verify(model).setTeam(Mockito.<TeamModel>any());
        verify(model).setUserId(anyInt());
        assertEquals(1, actualToResponseResult.getId());
        assertEquals(1, actualToResponseResult.getTeamId());
        assertEquals(1, actualToResponseResult.getUserId());
    }
}
