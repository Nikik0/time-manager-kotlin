package com.nikiko.timemanager.entity

import com.fasterxml.jackson.databind.BeanDescription
import jdk.jfr.Frequency
import lombok.Builder
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime


@Table("Events")
@NoArgsConstructor
@Builder(toBuilder = true)  //todo need to migrate to kotlin 1.8 with kotlin lombok
data class EventEntityKotlin(
    @Id
    val id: Long,
    val name: String,
    @Column("start_time")
    val startTime: LocalDateTime,
    val duration: Long,
    val enabled: Boolean,
    @Column("short_description")
    val shortDescription: String,
    @Column("full_description")
    val fullDescription: String,
    @Column("created_at")
    val createdAt: LocalDateTime,
    @Column("changed_at")
    val changedAt: LocalDateTime,
    @Column("owner_id")
    val ownerId: Long,
    @Column("next_event_time")
    val nextEventTime: LocalDateTime,
    @Column("was_postponed")
    val postponed: Boolean,
    @Column("last_happened")
    val lastHappened: LocalDateTime,
    val frequency: Long
)
