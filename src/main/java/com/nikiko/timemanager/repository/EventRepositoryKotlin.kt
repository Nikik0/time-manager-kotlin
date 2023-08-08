package com.nikiko.timemanager.repository

import com.nikiko.timemanager.entity.EventEntity
import com.nikiko.timemanager.entity.EventEntityKotlin
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.LocalDateTime

@Repository
interface EventRepositoryKotlin : R2dbcRepository<EventEntityKotlin, Long>{
    @Query("DELETE from events where id = $1")
    override fun deleteById(id: Long): Mono<Void>

    fun getEventEntitiesByNextEventTimeBetween(time: LocalDateTime, nextTime: LocalDateTime): Flux<EventEntity?>

    fun getEventEntitiesByOwnerId(id: Long): Flux<EventEntity?>

    fun getEventEntitiesByOwnerIdAndNextEventTimeBetween(
        id: Long,
        currentTime: LocalDateTime,
        nextTime: LocalDateTime
    ): Flux<EventEntity?>


}