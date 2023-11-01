package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingGame(
    val numOfRacingCar: Int, val numOfAttempts: Int,
    private val racingGameMoveRule: RacingGameMoveRule
) {
    var resultOfRacingCars: List<RacingCar> = emptyList()
        private set

    fun start(): List<RacingCarGameRound> {
        resultOfRacingCars = List(numOfRacingCar) { RacingCar(racingGameMoveRule) }

        val racingCarGameRound: MutableList<RacingCarGameRound> = mutableListOf()
        var round = 1
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
}
