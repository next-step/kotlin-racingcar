package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingGame(
    val namesOfRacingCar: String, val numOfAttempts: Int,
    private val racingGameMoveRule: RacingGameMoveRule
) {
    init {
        require(namesOfRacingCar.isNotBlank()) { "자동차 이름 입력은 공백일 수 없습니다." }
    }

    fun start(): List<RacingCarGameRound> {
        val resultOfRacingCars = namesOfRacingCar.split(",")
            .map { RacingCar(it, racingGameMoveRule) }

        val racingCarGameRound: MutableList<RacingCarGameRound> = mutableListOf()
        var round = START_ROUND
        repeat(numOfAttempts) {
            val movedRacingCars: MutableList<RacingCar> = mutableListOf()
            resultOfRacingCars.forEach {
                it.moveForward()
                movedRacingCars.add(it.copy())
            }

            racingCarGameRound.add(RacingCarGameRound(round++, movedRacingCars))
        }

        return racingCarGameRound
    }

    companion object {
        const val START_ROUND = 1
    }
}
