package com.nextstep.racingcar.domain

import com.nextstep.racingcar.view.OutputView

class RacingGame(numberOfCar: Int, round: Int) {
    private val cars: Cars
    private val round: Int

    init {
        validation(round)
        val cars = Cars(numberOfCar)
        this.cars = cars
        this.round = round
    }

    fun runGame() {
        for (i in 1..round) {
            cars.moveCars()
            OutputView.showStatus(cars)
        }
    }

    private fun validation(round: Int) {
        if (!round.isNatural()) {
            throw IllegalArgumentException("시도할 횟수는 0보다 커야합니다.")
        }
    }

    private fun Int.isNatural(): Boolean {
        return this > 0
    }
}
