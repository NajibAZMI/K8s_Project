package org.example.teamservice.controller;

import org.example.teamservice.dto.PlayerDTO;
import org.example.teamservice.entity.Player;
import org.example.teamservice.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping("/team/{teamId}")
    public List<PlayerDTO> getPlayersByTeam(@PathVariable Long teamId) {
        return playerService.getPlayersByTeam(teamId);
    }

    @PostMapping("/team/{teamId}")
    public ResponseEntity<PlayerDTO> addPlayer(@PathVariable Long teamId, @RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.addPlayerToTeam(teamId, player));
    }

    @PutMapping("/{id}")
    public PlayerDTO updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerService.updatePlayer(id, player);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
