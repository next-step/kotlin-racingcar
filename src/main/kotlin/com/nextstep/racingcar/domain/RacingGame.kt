package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural
import com.nextstep.racingcar.view.OutputView

class RacingGame(carName: String, round: Int?) {
    private val cars: Cars
    private val round: Int

    init {
        val carNames = carName.split(",")
        validation(carNames, round)
        this.cars = Cars(carNames.map { Car(it) })
        this.round = round ?: throw IllegalArgumentException("round가 잘못됨.")
    }

    private fun validation(carNames: List<String>, round: Int?) {
        if (!carNames.size.isNatural()) {
            throw IllegalArgumentException("자동차의 수량은 0보다 커야합니다.")
        }
        if (isInvalidRound(round)) {
            throw IllegalArgumentException("시도할 횟수는 0보다 커야합니다.")
        }
    }

    fun runGame() {
        for (i in 1..round) {
            cars.moveCars()
            OutputView.showStatus(cars)
        }
    }

    fun findWinners() {
        val winners = cars.findWinner()

        OutputView.showWinner(winners)
    }

    companion object {
        fun isInvalidRound(round: Int?): Boolean = round == null || !round.isNatural()
    }
}
