package com.kata.berlinclock.model

import com.kata.berlinclock.utils.LampColor

data class Hours(
    val topColors: List<LampColor> = default(),
    val bottomColors: List<LampColor> = default()
) {
    companion object {
        fun default() = MutableList(4) { LampColor.OFF }
    }
}
