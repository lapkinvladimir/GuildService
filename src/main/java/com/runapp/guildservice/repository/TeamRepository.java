package com.runapp.guildservice.repository;

import com.runapp.guildservice.model.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamModel, Integer> {
}
