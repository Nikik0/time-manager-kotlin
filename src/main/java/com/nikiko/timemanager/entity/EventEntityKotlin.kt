package com.nikiko.timemanager.entity

import com.fasterxml.jackson.databind.BeanDescription
import com.nikiko.timemanager.dto.EventDto
import com.nikiko.timemanager.dto.EventDtoKotlin
import jdk.jfr.Frequency
import lombok.Builder
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

fun EventEntityKotlin.toDto(): EventDtoKotlin =
    EventDtoKotlin(
        id = this.id,
        name = this.name,
        startTime = this.startTime,
        duration = this.duration,
        enabled = this.enabled,
        shortDescription = this.shortDescription,
        fullDescription = this.fullDescription,
        createdAt = this.createdAt,
        changedAt = this.changedAt,
        ownerId = this.ownerId,
        nextEventTime = this.nextEventTime,
        postponed = this.postponed,
        lastHappened = this.lastHappened,
        frequency = this.frequency
    )
@Table("Events")
data class EventEntityKotlin(
    @Id
    val id: Long,
    val name: String?,
    @Column("start_time")
    val startTime: LocalDateTime = LocalDateTime.now(),
    val duration: Long?,
    val enabled: Boolean = true,
    @Column("short_description")
    val shortDescription: String?,
    @Column("full_description")
    val fullDescription: String?,
    @Column("created_at")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @Column("changed_at")
    val changedAt: LocalDateTime = LocalDateTime.now(),
    @Column("owner_id")
    val ownerId: Long,
    @Column("next_event_time")
    val nextEventTime: LocalDateTime?,
    @Column("was_postponed")
    val postponed: Boolean = false,
    @Column("last_happened")
    val lastHappened: LocalDateTime?,
    val frequency: Long
)
