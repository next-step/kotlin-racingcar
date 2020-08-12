package com.nextstep.racingcar.domain

import com.nextstep.racingcar.util.isNatural

class RacingGame private constructor(val cars: Cars, val round: Int) {
    fun runRound() {
        cars.moveCars()
    }

    fun findWinners(): Cars {
        return cars.findWinner()
    }

    companion object {
        fun createGame(carName: String, round: Int): RacingGame {
            val carNames = carName.split(",")
            validation(carNames, round)

            val cars = Cars(carNames.map { Car(it) })
            return RacingGame(cars, round)
        }

        private fun validation(carNames: List<String>, round: Int?) {
            require(carNames.size.isNatural()) { "자동차의 수량은 0보다 커야합니다." }
            require(!isInvalidRound(round)) { "시도할 횟수는 0보다 커야합니다." }
        }

        fun isInvalidRound(round: Int?): Boolean = round == null || !round.isNatural()
    }
}
