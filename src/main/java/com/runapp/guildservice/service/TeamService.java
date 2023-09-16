package com.runapp.guildservice.service;

import com.runapp.guildservice.model.TeamModel;
import com.runapp.guildservice.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public TeamModel createTeam(TeamModel team) {
        return teamRepository.save(team);
    }

    public Optional<TeamModel> getTeamById(int id) {
        return teamRepository.findById(id);
    }

    public List<TeamModel> getAllTeams() {
        return teamRepository.findAll();
    }

    public TeamModel updateTeam(int id, TeamModel updatedTeam) {
        Optional<TeamModel> existingTeam = teamRepository.findById(id);
        if (existingTeam.isPresent()) {
            updatedTeam.setId(id);
            return teamRepository.save(updatedTeam);
        } else {
            throw new IllegalArgumentException("Team with ID " + id + " not found.");
        }
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }
}
