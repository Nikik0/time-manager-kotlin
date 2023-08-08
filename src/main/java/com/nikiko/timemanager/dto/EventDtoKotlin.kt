package com.nikiko.timemanager.dto

import java.time.LocalDateTime

data class EventDtoKotlin(
    val id: Long,
    val name: String?,
    val startTime: LocalDateTime,
    val duration: Long?,
    val enabled: Boolean,
    val shortDescription: String?,
    val fullDescription: String?,
    val createdAt: LocalDateTime,
    val changedAt: LocalDateTime,
    val ownerId: Long,
    val nextEventTime: LocalDateTime?,
    val postponed: Boolean,
    val lastHappened: LocalDateTime?,
    val frequency: Long
)
