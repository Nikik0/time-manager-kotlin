package com.nikiko.timemanager.service

import com.nikiko.timemanager.dto.EventDto
import com.nikiko.timemanager.dto.EventDtoKotlin
import com.nikiko.timemanager.dto.EventRequestDto
import com.nikiko.timemanager.dto.UserRequestDto
import com.nikiko.timemanager.entity.EventEntityKotlin
import com.nikiko.timemanager.entity.toDto
import com.nikiko.timemanager.mapper.EventMapper
import com.nikiko.timemanager.repository.EventRepository
import com.nikiko.timemanager.repository.EventRepositoryKotlin
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EventServiceKotlin (
    private val eventRepositoryKotlin: EventRepositoryKotlin,
    @Value("\${settings.delayEventTime}")
    private val postponeMinutes: Long,
    private val eventMapper: EventMapper
        ){

    fun getSingle(eventRequestDto: EventRequestDto): Mono<EventDtoKotlin> =
        eventRepositoryKotlin.findById(eventRequestDto.id).map { it.toDto() }
}