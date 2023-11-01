package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingGame(
    val numOfRacingCar: Int, val numOfAttempts: Int,
    private val racingGameMoveRule: RacingGameMoveRule
) {
    fun start(): List<RacingCarGameRound> {
        val resultOfRacingCars = List(numOfRacingCar) { RacingCar("parker", racingGameMoveRule) }

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
