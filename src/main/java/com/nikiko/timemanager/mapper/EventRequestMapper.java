package com.nikiko.timemanager.mapper;

import com.nikiko.timemanager.dto.EventRequestDto;
import com.nikiko.timemanager.entity.EventEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventRequestMapper {
    //todo combine event mappers into a single event mapper, 1 of the methods on each isn't used anyways
    EventEntity mapFromRequestToEntity(EventRequestDto requestDto);
    @InheritInverseConfiguration
    EventRequestDto mapFromEntityToRequest(EventEntity entity);
}
