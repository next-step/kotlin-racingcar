package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural
import com.nextstep.racingcar.view.OutputView

class RacingGame(carName: String, round: Int?) {
    private val cars: Cars
    private val round: Int

    init {
        validation(round)
        val cars = Cars(carName)
        this.cars = cars
        this.round = round ?: throw IllegalArgumentException("round가 잘못됨.")
    }

    fun runGame() {
        for (i in 1..round) {
            cars.moveCars()
            OutputView.showStatus(cars)
        }
    }

    private fun validation(round: Int?) {
        if (isInvalidRound(round)) {
            throw IllegalArgumentException("시도할 횟수는 0보다 커야합니다.")
        }
    }

    companion object {
        fun isInvalidRound(round: Int?): Boolean = round == null || !round.isNatural()
    }
}
