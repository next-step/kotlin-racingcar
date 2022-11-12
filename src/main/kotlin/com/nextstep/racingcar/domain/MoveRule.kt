package com.nextstep.racingcar.domain

interface MoveRule {
    fun move(number: Int): Movement
}
