package org.example.teamservice.service;


import org.example.teamservice.dto.PlayerDTO;
import org.example.teamservice.entity.Player;
import org.example.teamservice.entity.Team;
import org.example.teamservice.exception.PlayerNotFoundException;
import org.example.teamservice.exception.TeamNotFoundException;
import org.example.teamservice.mapper.PlayerMapper;
import org.example.teamservice.repository.PlayerRepository;
import org.example.teamservice.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;

    public List<PlayerDTO> getPlayersByTeam(Long teamId) {
        return playerRepository.findByTeamId(teamId)
                .stream()
                .map(playerMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PlayerDTO addPlayerToTeam(Long teamId, Player player) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException("Équipe non trouvée pour ID: " + teamId));
        player.setTeam(team);
        Player saved = playerRepository.save(player);
        return playerMapper.toDTO(saved);
    }


    public PlayerDTO updatePlayer(Long id, Player updated) {
        Player existing = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Joueur non trouvé ID: " + id));

        existing.setFullName(updated.getFullName());
        existing.setNumber(updated.getNumber());
        existing.setPosition(updated.getPosition());

        Player saved = playerRepository.save(existing);
        return playerMapper.toDTO(saved);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
