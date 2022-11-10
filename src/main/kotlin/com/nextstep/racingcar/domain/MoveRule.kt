package com.nextstep.racingcar.domain

interface MoveRule {
    fun movable(number: Int): Movement
}
