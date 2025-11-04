package org.example.teamservice.mapper;


import org.example.teamservice.dto.TeamDTO;
import org.example.teamservice.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {PlayerMapper.class})
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    TeamDTO toDTO(Team team);
    Team toEntity(TeamDTO dto);
}
