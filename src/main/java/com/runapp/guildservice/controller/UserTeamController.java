package com.runapp.guildservice.controller;

import com.runapp.guildservice.dto.request.UserTeamRequest;
import com.runapp.guildservice.dto.response.ExceptionResponse;
import com.runapp.guildservice.dto.response.UserResponse;
import com.runapp.guildservice.dto.response.UserTeamResponse;
import com.runapp.guildservice.feignClient.ProfileServiceClient;
import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.model.UserTeamModel;
import com.runapp.guildservice.service.TeamService;
import com.runapp.guildservice.service.UserTeamService;
import com.runapp.guildservice.dto.dtoMapper.UserTeamDtoMapper;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/userteams")
public class UserTeamController {

    private final UserTeamService userTeamService;
    private final UserTeamDtoMapper userTeamDtoMapper;
    private final TeamService teamService;

    private final ProfileServiceClient profileServiceClient;

    @Autowired
    public UserTeamController(UserTeamService userTeamService, UserTeamDtoMapper userTeamDtoMapper, TeamService teamService, ProfileServiceClient profileServiceClient) {
        this.userTeamService = userTeamService;
        this.userTeamDtoMapper = userTeamDtoMapper;
        this.teamService = teamService;
        this.profileServiceClient = profileServiceClient;
    }

    @PostMapping
    public ResponseEntity<Object> createUserTeam(@Valid @RequestBody UserTeamRequest userTeamRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Обработка ошибок валидации
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            UserResponse userResponse = profileServiceClient.getUserById(userTeamRequest.getUserId()).getBody();
            Optional<TeamModel> teamModel = teamService.getTeamById(userTeamRequest.getTeam_id());
            if (teamModel.isEmpty())
                return ResponseEntity.badRequest().body(
                        new ExceptionResponse(LocalDateTime.now(),
                                "Team with id " + userTeamRequest.getTeam_id() + " nor found"));
            UserTeamModel userTeamModel = userTeamDtoMapper.toModel(userTeamRequest, teamModel.orElse(null));
            UserTeamModel createdUserTeam = userTeamService.createUserTeam(userTeamModel);
            UserTeamResponse userTeamResponse = userTeamDtoMapper.toResponse(createdUserTeam);
            return new ResponseEntity<>(userTeamResponse, HttpStatus.CREATED);
        } catch (FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(LocalDateTime.now(), "Story or Admin with ID " + userTeamRequest.getUserId() + " not found"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTeamResponse> getUserTeamById(@PathVariable int id) {
        return userTeamService.getUserTeamById(id)
                .map(userTeamDtoMapper::toResponse)
                .map(response -> new ResponseEntity<>(response, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UserTeamResponse>> getAllUserTeams() {
        List<UserTeamResponse> userTeams = userTeamService.getAllUserTeam().stream()
                .map(userTeamDtoMapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(userTeams, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUserTeam(@PathVariable int id, @Valid @RequestBody UserTeamRequest userTeamRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Обработка ошибок валидации
            List<String> errors = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(errors);
        }
        try {
            UserResponse userResponse = profileServiceClient.getUserById(userTeamRequest.getUserId()).getBody();
            Optional<TeamModel> teamModel = teamService.getTeamById(userTeamRequest.getTeam_id());
            if (teamModel.isEmpty())
                return ResponseEntity.badRequest().body(
                        new ExceptionResponse(LocalDateTime.now(),
                                "Team with id " + userTeamRequest.getTeam_id() + " nor found"));
            UserTeamModel userTeamModel = userTeamDtoMapper.toModel(userTeamRequest, teamModel.orElse(null));
            UserTeamModel updatedUserTeam = userTeamService.updateUserTeam(id, userTeamModel);
            UserTeamResponse userTeamResponse = userTeamDtoMapper.toResponse(updatedUserTeam);
            return new ResponseEntity<>(userTeamResponse, HttpStatus.OK);
        } catch (FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(LocalDateTime.now(), "User with ID " + userTeamRequest.getUserId() + " not found"));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserTeam(@PathVariable int id) {
        Optional<UserTeamModel> userTeamModel = userTeamService.getUserTeamById(id);
        if (userTeamModel.isEmpty()) return ResponseEntity.badRequest().body(
                new ExceptionResponse(LocalDateTime.now(),
                        "User-Team with id " + id + " nor found"));
        userTeamService.deleteUserTeam(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
