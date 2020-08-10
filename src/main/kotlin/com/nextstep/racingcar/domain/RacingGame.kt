package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural

class RacingGame(carName: String, round: Int?) {
    val cars: Cars
    val round: Int

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

    fun runRound() {
        cars.moveCars()
    }

    fun findWinners(): Cars {
        return cars.findWinner()
    }

    companion object {
        fun isInvalidRound(round: Int?): Boolean = round == null || !round.isNatural()
    }
}
