package com.runapp.guildservice.repository;

import com.runapp.guildservice.model.UserTeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamRepository extends JpaRepository<UserTeamModel, Integer> {
}
