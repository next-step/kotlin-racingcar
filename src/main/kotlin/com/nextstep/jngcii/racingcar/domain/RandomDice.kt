package com.nextstep.jngcii.racingcar.domain

import java.util.Random

class RandomDice : Dice {
    companion object {
        private const val END_EXCLUSIVE = 10
        private const val PIVOT = 4
    }

    private val random = Random()

    override fun run() = random.nextInt(END_EXCLUSIVE) >= PIVOT
}
