package com.runapp.guildservice.service;

import com.runapp.guildservice.model.UserTeamModel;
import com.runapp.guildservice.repository.UserTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTeamService {

    private final UserTeamRepository userTeamRepository;

    @Autowired
    public UserTeamService(UserTeamRepository userTeamRepository) {
        this.userTeamRepository = userTeamRepository;
    }

    public UserTeamModel createUserTeam(UserTeamModel userTeam) {
        return userTeamRepository.save(userTeam);
    }

    public Optional<UserTeamModel> getUserTeamById(int id) {
        return userTeamRepository.findById(id);
    }

    public List<UserTeamModel> getAllUserTeam() {
        return userTeamRepository.findAll();
    }

    public UserTeamModel updateUserTeam(int id, UserTeamModel updatedUserTeam) {
        Optional<UserTeamModel> existingUserTeam = userTeamRepository.findById(id);
        if (existingUserTeam.isPresent()) {
            updatedUserTeam.setId(id);
            return userTeamRepository.save(updatedUserTeam);
        } else {
            throw new IllegalArgumentException("Depend of user with command with ID " + id + " not found.");
        }
    }

    public void deleteUserTeam(int id) {
        userTeamRepository.deleteById(id);
    }
}
