package com.runapp.guildservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.repository.TeamRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TeamService.class})
@ExtendWith(SpringExtension.class)
class TeamServiceDiffblueTest {
    @MockBean
    private TeamRepository teamRepository;

    @Autowired
    private TeamService teamService;

    /**
     * Method under test: {@link TeamService#createTeam(TeamModel)}
     */
    @Test
    void testCreateTeam() {
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
        when(teamRepository.save(Mockito.<TeamModel>any())).thenReturn(teamModel);

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
        TeamModel actualCreateTeamResult = teamService.createTeam(team);
        verify(teamRepository).save(Mockito.<TeamModel>any());
        assertSame(teamModel, actualCreateTeamResult);
    }

    /**
     * Method under test: {@link TeamService#createTeam(TeamModel)}
     */
    @Test
    void testCreateTeam2() {
        when(teamRepository.save(Mockito.<TeamModel>any())).thenThrow(new IllegalArgumentException("foo"));

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
        assertThrows(IllegalArgumentException.class, () -> teamService.createTeam(team));
        verify(teamRepository).save(Mockito.<TeamModel>any());
    }

    /**
     * Method under test: {@link TeamService#getTeamById(int)}
     */
    @Test
    void testGetTeamById() {
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
        Optional<TeamModel> ofResult = Optional.of(teamModel);
        when(teamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Optional<TeamModel> actualTeamById = teamService.getTeamById(1);
        verify(teamRepository).findById(Mockito.<Integer>any());
        assertTrue(actualTeamById.isPresent());
        assertSame(ofResult, actualTeamById);
    }

    /**
     * Method under test: {@link TeamService#getTeamById(int)}
     */
    @Test
    void testGetTeamById2() {
        when(teamRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> teamService.getTeamById(1));
        verify(teamRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link TeamService#getAllTeams()}
     */
    @Test
    void testGetAllTeams() {
        ArrayList<TeamModel> teamModelList = new ArrayList<>();
        when(teamRepository.findAll()).thenReturn(teamModelList);
        List<TeamModel> actualAllTeams = teamService.getAllTeams();
        verify(teamRepository).findAll();
        assertTrue(actualAllTeams.isEmpty());
        assertSame(teamModelList, actualAllTeams);
    }

    /**
     * Method under test: {@link TeamService#getAllTeams()}
     */
    @Test
    void testGetAllTeams2() {
        when(teamRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> teamService.getAllTeams());
        verify(teamRepository).findAll();
    }

    /**
     * Method under test: {@link TeamService#updateTeam(int, TeamModel)}
     */
    @Test
    void testUpdateTeam() {
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
        Optional<TeamModel> ofResult = Optional.of(teamModel);

        TeamModel teamModel2 = new TeamModel();
        teamModel2.setAdminId(1);
        teamModel2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        teamModel2.setDescriptionTeam("Description Team");
        teamModel2.setId(1);
        teamModel2.setMaximumPlayers(3);
        teamModel2.setRanking(1L);
        teamModel2.setStoryId(1);
        teamModel2.setTeamImageUrl("https://example.org/example");
        teamModel2.setTeamName("Team Name");
        teamModel2.setUserTeamModelList(new ArrayList<>());
        when(teamRepository.save(Mockito.<TeamModel>any())).thenReturn(teamModel2);
        when(teamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        TeamModel updatedTeam = new TeamModel();
        updatedTeam.setAdminId(1);
        updatedTeam.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedTeam.setDescriptionTeam("Description Team");
        updatedTeam.setId(1);
        updatedTeam.setMaximumPlayers(3);
        updatedTeam.setRanking(1L);
        updatedTeam.setStoryId(1);
        updatedTeam.setTeamImageUrl("https://example.org/example");
        updatedTeam.setTeamName("Team Name");
        updatedTeam.setUserTeamModelList(new ArrayList<>());
        TeamModel actualUpdateTeamResult = teamService.updateTeam(1, updatedTeam);
        verify(teamRepository).findById(Mockito.<Integer>any());
        verify(teamRepository).save(Mockito.<TeamModel>any());
        assertEquals(1, updatedTeam.getId());
        assertSame(teamModel2, actualUpdateTeamResult);
    }

    /**
     * Method under test: {@link TeamService#updateTeam(int, TeamModel)}
     */
    @Test
    void testUpdateTeam2() {
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
        Optional<TeamModel> ofResult = Optional.of(teamModel);
        when(teamRepository.save(Mockito.<TeamModel>any())).thenThrow(new IllegalArgumentException("foo"));
        when(teamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        TeamModel updatedTeam = new TeamModel();
        updatedTeam.setAdminId(1);
        updatedTeam.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedTeam.setDescriptionTeam("Description Team");
        updatedTeam.setId(1);
        updatedTeam.setMaximumPlayers(3);
        updatedTeam.setRanking(1L);
        updatedTeam.setStoryId(1);
        updatedTeam.setTeamImageUrl("https://example.org/example");
        updatedTeam.setTeamName("Team Name");
        updatedTeam.setUserTeamModelList(new ArrayList<>());
        assertThrows(IllegalArgumentException.class, () -> teamService.updateTeam(1, updatedTeam));
        verify(teamRepository).findById(Mockito.<Integer>any());
        verify(teamRepository).save(Mockito.<TeamModel>any());
    }

    /**
     * Method under test: {@link TeamService#updateTeam(int, TeamModel)}
     */
    @Test
    void testUpdateTeam3() {
        Optional<TeamModel> emptyResult = Optional.empty();
        when(teamRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        TeamModel updatedTeam = new TeamModel();
        updatedTeam.setAdminId(1);
        updatedTeam.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        updatedTeam.setDescriptionTeam("Description Team");
        updatedTeam.setId(1);
        updatedTeam.setMaximumPlayers(3);
        updatedTeam.setRanking(1L);
        updatedTeam.setStoryId(1);
        updatedTeam.setTeamImageUrl("https://example.org/example");
        updatedTeam.setTeamName("Team Name");
        updatedTeam.setUserTeamModelList(new ArrayList<>());
        assertThrows(IllegalArgumentException.class, () -> teamService.updateTeam(1, updatedTeam));
        verify(teamRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link TeamService#deleteTeam(int)}
     */
    @Test
    void testDeleteTeam() {
        doNothing().when(teamRepository).deleteById(Mockito.<Integer>any());
        teamService.deleteTeam(1);
        verify(teamRepository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link TeamService#deleteTeam(int)}
     */
    @Test
    void testDeleteTeam2() {
        doThrow(new IllegalArgumentException("foo")).when(teamRepository).deleteById(Mockito.<Integer>any());
        assertThrows(IllegalArgumentException.class, () -> teamService.deleteTeam(1));
        verify(teamRepository).deleteById(Mockito.<Integer>any());
    }
}
