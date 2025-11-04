package org.example.teamservice.service;

import lombok.RequiredArgsConstructor;
import org.example.teamservice.entity.Team;
import org.example.teamservice.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import org.example.teamservice.exception.TeamNotFoundException;


import org.example.teamservice.dto.TeamDTO;
import org.example.teamservice.mapper.TeamMapper;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;


    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamMapper::toDTO)
                .collect(Collectors.toList());
    }


    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Équipe non trouvée avec ID: " + id));
        return teamMapper.toDTO(team);
    }


    public TeamDTO createTeam(Team team) {
        Team saved = teamRepository.save(team);
        return teamMapper.toDTO(saved);
    }


    public TeamDTO updateTeam(Long id, Team newTeam) {
        Team existing = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Équipe non trouvée avec ID: " + id));

        existing.setName(newTeam.getName());
        existing.setCountry(newTeam.getCountry());

        Team saved = teamRepository.save(existing);
        return teamMapper.toDTO(saved);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}

