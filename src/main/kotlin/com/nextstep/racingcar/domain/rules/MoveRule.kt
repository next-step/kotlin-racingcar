package com.nextstep.racingcar.domain.rules

import com.nextstep.racingcar.domain.Movement

fun interface MoveRule {
    fun move(): Movement
}
