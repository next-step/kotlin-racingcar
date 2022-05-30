package com.nextstep.jngcii.racingcar.domain

class RandomDice : Dice {
    override fun shouldRun() = (START_NUMBER..END_NUMBER).random() >= PIVOT

    companion object {
        private const val START_NUMBER = 0
        private const val END_NUMBER = 9
        private const val PIVOT = 4
    }
}
