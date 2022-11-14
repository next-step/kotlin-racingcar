package com.nextstep.racingcar.domain.gamerules

import com.nextstep.racingcar.domain.Movement

interface MoveRule {
    fun move(): Movement
}
