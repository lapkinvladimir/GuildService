package com.runapp.guildservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.runapp.guildservice.dto.dtoMapper.UserTeamDtoMapper;
import com.runapp.guildservice.dto.request.UserTeamRequest;
import com.runapp.guildservice.dto.response.ExceptionResponse;
import com.runapp.guildservice.dto.response.UserResponse;
import com.runapp.guildservice.feignClient.ProfileServiceClient;
import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.model.UserTeamModel;
import com.runapp.guildservice.service.TeamService;
import com.runapp.guildservice.service.UserTeamService;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(UserTeamController.class)
public class UserTeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserTeamService userTeamService;

    @MockBean
    private UserTeamDtoMapper userTeamDtoMapper;

    @MockBean
    private TeamService teamService;

    @MockBean
    private ProfileServiceClient profileServiceClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateUserTeamWhenValidRequestThenSuccess() throws Exception {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        UserResponse userResponse = new UserResponse();
        TeamModel teamModel = new TeamModel();
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenReturn(ResponseEntity.ok(userResponse));
        when(teamService.getTeamById(userTeamRequest.getTeam_id())).thenReturn(Optional.of(teamModel));

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/userteams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testCreateUserTeamWhenInvalidRequestThenBadRequest() throws Exception {
        UserTeamRequest userTeamRequest = new UserTeamRequest(0, 0);

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/userteams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testCreateUserTeamWhenUserNotFoundThenNotFound() throws Exception {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenThrow(FeignException.NotFound.class);

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/userteams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testCreateUserTeamWhenTeamNotFoundThenBadRequest() throws Exception {
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        UserResponse userResponse = new UserResponse();
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenReturn(ResponseEntity.ok(userResponse));
        when(teamService.getTeamById(userTeamRequest.getTeam_id())).thenReturn(Optional.empty());

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/userteams")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testGetUserTeamByIdWhenUserTeamDoesNotExistThenNotFound() throws Exception {
        int id = 1;
        when(userTeamService.getUserTeamById(id)).thenReturn(Optional.empty());
        mockMvc.perform(MockMvcRequestBuilders.get("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdateUserTeamWhenValidRequestThenSuccess() throws Exception {
        int id = 1;
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        UserResponse userResponse = new UserResponse();
        TeamModel teamModel = new TeamModel();
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenReturn(ResponseEntity.ok(userResponse));
        when(teamService.getTeamById(userTeamRequest.getTeam_id())).thenReturn(Optional.of(teamModel));

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateUserTeamWhenInvalidRequestThenBadRequest() throws Exception {
        int id = 1;
        UserTeamRequest userTeamRequest = new UserTeamRequest(0, 0);

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testUpdateUserTeamWhenUserNotFoundThenNotFound() throws Exception {
        int id = 1;
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenThrow(FeignException.NotFound.class);

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void testUpdateUserTeamWhenTeamNotFoundThenBadRequest() throws Exception {
        int id = 1;
        UserTeamRequest userTeamRequest = new UserTeamRequest(1, 1);
        UserResponse userResponse = new UserResponse();
        when(profileServiceClient.getUserById(userTeamRequest.getUserId())).thenReturn(ResponseEntity.ok(userResponse));
        when(teamService.getTeamById(userTeamRequest.getTeam_id())).thenReturn(Optional.empty());

        String jsonRequest = objectMapper.writeValueAsString(userTeamRequest);

        mockMvc.perform(MockMvcRequestBuilders.put("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void testDeleteUserTeamWhenUserTeamExistsThenNoContent() throws Exception {
        int id = 1;
        when(userTeamService.getUserTeamById(id)).thenReturn(Optional.of(new UserTeamModel()));
        mockMvc.perform(MockMvcRequestBuilders.delete("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testDeleteUserTeamWhenUserTeamDoesNotExistThenBadRequest() throws Exception {
        int id = 1;
        when(userTeamService.getUserTeamById(id)).thenReturn(Optional.empty());
        mockMvc.perform(MockMvcRequestBuilders.delete("/userteams/" + id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}