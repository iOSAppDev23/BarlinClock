package com.kata.berlinclock.model

import com.kata.berlinclock.utils.LampColor

data class BerlinClockData(
    val secondsOnLamp: LampColor,
    val minutesOnLamps: Minutes,
    val hoursOnLamps: Hours
) {
    companion object {
        fun initial() = BerlinClockData(LampColor.OFF, Minutes(), Hours())
    }
}