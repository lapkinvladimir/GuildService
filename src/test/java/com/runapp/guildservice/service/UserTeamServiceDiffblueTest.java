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
import com.runapp.guildservice.model.UserTeamModel;
import com.runapp.guildservice.repository.UserTeamRepository;

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

@ContextConfiguration(classes = {UserTeamService.class})
@ExtendWith(SpringExtension.class)
class UserTeamServiceDiffblueTest {
    @MockBean
    private UserTeamRepository userTeamRepository;

    @Autowired
    private UserTeamService userTeamService;

    /**
     * Method under test: {@link UserTeamService#createUserTeam(UserTeamModel)}
     */
    @Test
    void testCreateUserTeam() {
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

        UserTeamModel userTeamModel = new UserTeamModel();
        userTeamModel.setId(1);
        userTeamModel.setTeam(team);
        userTeamModel.setUserId(1);
        when(userTeamRepository.save(Mockito.<UserTeamModel>any())).thenReturn(userTeamModel);

        TeamModel team2 = new TeamModel();
        team2.setAdminId(1);
        team2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team2.setDescriptionTeam("Description Team");
        team2.setId(1);
        team2.setMaximumPlayers(3);
        team2.setRanking(1L);
        team2.setStoryId(1);
        team2.setTeamImageUrl("https://example.org/example");
        team2.setTeamName("Team Name");
        team2.setUserTeamModelList(new ArrayList<>());

        UserTeamModel userTeam = new UserTeamModel();
        userTeam.setId(1);
        userTeam.setTeam(team2);
        userTeam.setUserId(1);
        UserTeamModel actualCreateUserTeamResult = userTeamService.createUserTeam(userTeam);
        verify(userTeamRepository).save(Mockito.<UserTeamModel>any());
        assertSame(userTeamModel, actualCreateUserTeamResult);
    }

    /**
     * Method under test: {@link UserTeamService#createUserTeam(UserTeamModel)}
     */
    @Test
    void testCreateUserTeam2() {
        when(userTeamRepository.save(Mockito.<UserTeamModel>any())).thenThrow(new IllegalArgumentException("foo"));

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

        UserTeamModel userTeam = new UserTeamModel();
        userTeam.setId(1);
        userTeam.setTeam(team);
        userTeam.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> userTeamService.createUserTeam(userTeam));
        verify(userTeamRepository).save(Mockito.<UserTeamModel>any());
    }

    /**
     * Method under test: {@link UserTeamService#getUserTeamById(int)}
     */
    @Test
    void testGetUserTeamById() {
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

        UserTeamModel userTeamModel = new UserTeamModel();
        userTeamModel.setId(1);
        userTeamModel.setTeam(team);
        userTeamModel.setUserId(1);
        Optional<UserTeamModel> ofResult = Optional.of(userTeamModel);
        when(userTeamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Optional<UserTeamModel> actualUserTeamById = userTeamService.getUserTeamById(1);
        verify(userTeamRepository).findById(Mockito.<Integer>any());
        assertTrue(actualUserTeamById.isPresent());
        assertSame(ofResult, actualUserTeamById);
    }

    /**
     * Method under test: {@link UserTeamService#getUserTeamById(int)}
     */
    @Test
    void testGetUserTeamById2() {
        when(userTeamRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userTeamService.getUserTeamById(1));
        verify(userTeamRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UserTeamService#getAllUserTeam()}
     */
    @Test
    void testGetAllUserTeam() {
        ArrayList<UserTeamModel> userTeamModelList = new ArrayList<>();
        when(userTeamRepository.findAll()).thenReturn(userTeamModelList);
        List<UserTeamModel> actualAllUserTeam = userTeamService.getAllUserTeam();
        verify(userTeamRepository).findAll();
        assertTrue(actualAllUserTeam.isEmpty());
        assertSame(userTeamModelList, actualAllUserTeam);
    }

    /**
     * Method under test: {@link UserTeamService#getAllUserTeam()}
     */
    @Test
    void testGetAllUserTeam2() {
        when(userTeamRepository.findAll()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> userTeamService.getAllUserTeam());
        verify(userTeamRepository).findAll();
    }

    /**
     * Method under test: {@link UserTeamService#updateUserTeam(int, UserTeamModel)}
     */
    @Test
    void testUpdateUserTeam() {
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

        UserTeamModel userTeamModel = new UserTeamModel();
        userTeamModel.setId(1);
        userTeamModel.setTeam(team);
        userTeamModel.setUserId(1);
        Optional<UserTeamModel> ofResult = Optional.of(userTeamModel);

        TeamModel team2 = new TeamModel();
        team2.setAdminId(1);
        team2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team2.setDescriptionTeam("Description Team");
        team2.setId(1);
        team2.setMaximumPlayers(3);
        team2.setRanking(1L);
        team2.setStoryId(1);
        team2.setTeamImageUrl("https://example.org/example");
        team2.setTeamName("Team Name");
        team2.setUserTeamModelList(new ArrayList<>());

        UserTeamModel userTeamModel2 = new UserTeamModel();
        userTeamModel2.setId(1);
        userTeamModel2.setTeam(team2);
        userTeamModel2.setUserId(1);
        when(userTeamRepository.save(Mockito.<UserTeamModel>any())).thenReturn(userTeamModel2);
        when(userTeamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        TeamModel team3 = new TeamModel();
        team3.setAdminId(1);
        team3.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team3.setDescriptionTeam("Description Team");
        team3.setId(1);
        team3.setMaximumPlayers(3);
        team3.setRanking(1L);
        team3.setStoryId(1);
        team3.setTeamImageUrl("https://example.org/example");
        team3.setTeamName("Team Name");
        team3.setUserTeamModelList(new ArrayList<>());

        UserTeamModel updatedUserTeam = new UserTeamModel();
        updatedUserTeam.setId(1);
        updatedUserTeam.setTeam(team3);
        updatedUserTeam.setUserId(1);
        UserTeamModel actualUpdateUserTeamResult = userTeamService.updateUserTeam(1, updatedUserTeam);
        verify(userTeamRepository).findById(Mockito.<Integer>any());
        verify(userTeamRepository).save(Mockito.<UserTeamModel>any());
        assertEquals(1, updatedUserTeam.getId());
        assertSame(userTeamModel2, actualUpdateUserTeamResult);
    }

    /**
     * Method under test: {@link UserTeamService#updateUserTeam(int, UserTeamModel)}
     */
    @Test
    void testUpdateUserTeam2() {
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

        UserTeamModel userTeamModel = new UserTeamModel();
        userTeamModel.setId(1);
        userTeamModel.setTeam(team);
        userTeamModel.setUserId(1);
        Optional<UserTeamModel> ofResult = Optional.of(userTeamModel);
        when(userTeamRepository.save(Mockito.<UserTeamModel>any())).thenThrow(new IllegalArgumentException("foo"));
        when(userTeamRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        TeamModel team2 = new TeamModel();
        team2.setAdminId(1);
        team2.setCreateDate(LocalDate.of(1970, 1, 1).atStartOfDay());
        team2.setDescriptionTeam("Description Team");
        team2.setId(1);
        team2.setMaximumPlayers(3);
        team2.setRanking(1L);
        team2.setStoryId(1);
        team2.setTeamImageUrl("https://example.org/example");
        team2.setTeamName("Team Name");
        team2.setUserTeamModelList(new ArrayList<>());

        UserTeamModel updatedUserTeam = new UserTeamModel();
        updatedUserTeam.setId(1);
        updatedUserTeam.setTeam(team2);
        updatedUserTeam.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> userTeamService.updateUserTeam(1, updatedUserTeam));
        verify(userTeamRepository).findById(Mockito.<Integer>any());
        verify(userTeamRepository).save(Mockito.<UserTeamModel>any());
    }

    /**
     * Method under test: {@link UserTeamService#updateUserTeam(int, UserTeamModel)}
     */
    @Test
    void testUpdateUserTeam3() {
        Optional<UserTeamModel> emptyResult = Optional.empty();
        when(userTeamRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

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

        UserTeamModel updatedUserTeam = new UserTeamModel();
        updatedUserTeam.setId(1);
        updatedUserTeam.setTeam(team);
        updatedUserTeam.setUserId(1);
        assertThrows(IllegalArgumentException.class, () -> userTeamService.updateUserTeam(1, updatedUserTeam));
        verify(userTeamRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UserTeamService#deleteUserTeam(int)}
     */
    @Test
    void testDeleteUserTeam() {
        doNothing().when(userTeamRepository).deleteById(Mockito.<Integer>any());
        userTeamService.deleteUserTeam(1);
        verify(userTeamRepository).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link UserTeamService#deleteUserTeam(int)}
     */
    @Test
    void testDeleteUserTeam2() {
        doThrow(new IllegalArgumentException("foo")).when(userTeamRepository).deleteById(Mockito.<Integer>any());
        assertThrows(IllegalArgumentException.class, () -> userTeamService.deleteUserTeam(1));
        verify(userTeamRepository).deleteById(Mockito.<Integer>any());
    }
}
