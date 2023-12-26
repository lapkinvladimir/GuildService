package com.runapp.guildservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.guildservice.dto.dtoMapper.TeamDtoMapper;
import com.runapp.guildservice.dto.request.DeleteStorageRequest;
import com.runapp.guildservice.dto.request.TeamDeleteRequest;
import com.runapp.guildservice.dto.request.TeamRequest;
import com.runapp.guildservice.dto.request.TeamUpdateRequest;
import com.runapp.guildservice.dto.response.TeamResponse;
import com.runapp.guildservice.feignClient.ProfileServiceClient;
import com.runapp.guildservice.feignClient.StorageServiceClient;
import com.runapp.guildservice.feignClient.StoryManagementServiceClient;
import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.service.TeamService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {TeamController.class})
@ExtendWith(SpringExtension.class)
class TeamControllerDiffblueTest {

    @Autowired
    private TeamController teamController;

    @MockBean
    private ProfileServiceClient profileServiceClient;

    @MockBean
    private StorageServiceClient storageServiceClient;

    @MockBean
    private StoryManagementServiceClient storyManagementServiceClient;

    @MockBean
    private TeamDtoMapper teamDtoMapper;

    @MockBean
    private TeamService teamService;


    /**
     * Methods under test:
     * {@link TeamController#createTeam(TeamRequest, BindingResult)}
     */


    /**
     * Тест успешного создания команды: отправка корректных данных методом GET и ожидание статуса 200
     * Successful Team Creation Test: Sending Correct Data via the GET Method and Expecting a Status Code of 200
     */
    @Test
    void testCreateTeam() throws Exception {
        when(teamService.getAllTeams()).thenReturn(new ArrayList<>());

        TeamRequest teamRequest = new TeamRequest();
        teamRequest.setAdminId(1);
        teamRequest.setDescriptionTeam("Description Team");
        teamRequest.setMaximumPlayers(3);
        teamRequest.setStoryId(1);
        teamRequest.setTeamName("Team Name");
        String content = (new ObjectMapper()).writeValueAsString(teamRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Тест создания команды с некорректными данными: отправка данных с ошибками и ожидание статуса 400
     * Team Creation Test with Incorrect Data: Sending Data with Errors and Expecting a Status Code of 400
     */
    @Test
    void testCreateTeamWithInvalidInput() throws Exception {
        TeamRequest teamRequest = new TeamRequest();
        teamRequest.setAdminId(1);
        teamRequest.setDescriptionTeam("Description Team");
        teamRequest.setMaximumPlayers(-1);  // Incorrect Value for Maximum Number of Players
        teamRequest.setStoryId(1);
        teamRequest.setTeamName("Team Name");

        String content = (new ObjectMapper()).writeValueAsString(teamRequest);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }








    /**
     * Method under test: {@link TeamController#getTeamById(int)}
     */
    @Test
    void testGetTeamById() throws Exception {
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
        when(teamService.getTeamById(anyInt())).thenReturn(ofResult);
        when(teamDtoMapper.toResponse(Mockito.<TeamModel>any())).thenReturn(new TeamResponse());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams/{id}", 1);
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":0,\"teamName\":null,\"descriptionTeam\":null,\"createDate\":null,\"teamImageUrl\":null,\"ranking\":null,"
                                        + "\"storyId\":0,\"maximumPlayers\":0,\"adminId\":0,\"users_in_team\":null}"));
    }

    /**
     * Method under test: {@link TeamController#getTeamById(int)}
     */
    @Test
    void testGetTeamById2() throws Exception {
        Optional<TeamModel> emptyResult = Optional.empty();
        when(teamService.getTeamById(anyInt())).thenReturn(emptyResult);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(teamDtoMapper.toResponse(Mockito.<TeamModel>any())).thenThrow(feignException);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(teamController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link TeamController#getAllTeams()}
     */
    @Test
    void testGetAllTeams() throws Exception {
        when(teamService.getAllTeams()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/teams");
        MockMvcBuilders.standaloneSetup(teamController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }


    /**
     * Method under test: {@link TeamController#deleteTeam(int)}
     */
    @Test
    void testDeleteTeam() throws Exception {
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
        doNothing().when(teamService).deleteTeam(anyInt());
        when(teamService.getTeamById(anyInt())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/teams/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(teamController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link TeamController#deleteImage(TeamDeleteRequest)}
     */
    @Test
    void testDeleteImage() throws Exception {
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
        when(teamService.updateTeam(anyInt(), Mockito.<TeamModel>any())).thenReturn(teamModel);
        Optional<TeamModel> emptyResult = Optional.empty();
        when(teamService.getTeamById(anyInt())).thenReturn(emptyResult);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(storageServiceClient.deleteFile(Mockito.<DeleteStorageRequest>any())).thenThrow(feignException);

        TeamDeleteRequest teamDeleteRequest = new TeamDeleteRequest();
        teamDeleteRequest.setFile_uri("File uri");
        teamDeleteRequest.setTeam_id(1);
        String content = (new ObjectMapper()).writeValueAsString(teamDeleteRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/teams/delete-image")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(teamController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Team with id 1 not found"));
    }

    /**
     * Method under test:
     * {@link TeamController#updateTeam(int, TeamUpdateRequest, BindingResult)}
     */
    @Test
    void testUpdateTeam() throws Exception {
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
        when(teamService.getTeamById(anyInt())).thenReturn(ofResult);
        FeignException feignException = mock(FeignException.class);
        when(feignException.getCause()).thenReturn(new Throwable());
        when(storyManagementServiceClient.getStoryById(anyInt())).thenThrow(feignException);

        TeamUpdateRequest teamUpdateRequest = new TeamUpdateRequest();
        teamUpdateRequest.setAdminId(0);
        teamUpdateRequest.setDescriptionTeam("Description Team");
        teamUpdateRequest.setMaximumPlayers(3);
        teamUpdateRequest.setRanking(1L);
        teamUpdateRequest.setStoryId(1);
        teamUpdateRequest.setTeamName("Team Name");
        String content = (new ObjectMapper()).writeValueAsString(teamUpdateRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/teams/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(teamController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[\"Admin ID must be a positive integer\"]"));
    }

    /**
     * Method under test: {@link TeamController#uploadImage(int, MultipartFile)}
     */
    @Test
    void testUploadImage() throws Exception {
        DataInputStream contentStream = mock(DataInputStream.class);
        when(contentStream.readAllBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
        doNothing().when(contentStream).close();
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/teams/upload-image")
                .param("file", String.valueOf(new MockMultipartFile("Name", contentStream)))
                .param("team_id", "https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(teamController).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}
