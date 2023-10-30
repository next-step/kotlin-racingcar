package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RacingGameMoveRule

class RacingGame(
    val numOfRacingCar: Int, val numOfAttempts: Int,
    private val racingGameMoveRule: RacingGameMoveRule
) {
    fun start(): List<RacingCar> {
        val racingCar = List(numOfRacingCar) { RacingCar(racingGameMoveRule) }

        repeat(numOfAttempts) {
            racingCar.forEach { it.moveForward() }
        }

        return racingCar
    }
}
