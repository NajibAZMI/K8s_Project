package org.example.teamservice.mapper;

import org.example.teamservice.dto.PlayerDTO;
import org.example.teamservice.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    PlayerDTO toDTO(Player player);
    Player toEntity(PlayerDTO dto);
}
