package com.nextstep.racingcar.domain.rules

import com.nextstep.racingcar.domain.Movement

interface MoveRule {
    fun move(): Movement
}
