package org.example.teamservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.teamservice.dto.TeamDTO;
import org.example.teamservice.entity.Team;
import org.example.teamservice.service.TeamService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping
    public List<TeamDTO> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody Team team) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teamService.createTeam(team));
    }

    @PutMapping("/{id}")
    public TeamDTO updateTeam(@PathVariable Long id, @RequestBody Team team) {
        return teamService.updateTeam(id, team);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
