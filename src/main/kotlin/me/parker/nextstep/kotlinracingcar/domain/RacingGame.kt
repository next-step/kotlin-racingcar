package me.parker.nextstep.kotlinracingcar.domain

import me.parker.nextstep.kotlinracingcar.domain.rule.RacingGameMoveRule

class RacingGame(
    private val namesOfRacingCar: List<String>, private val numOfAttempts: Int,
    private val racingGameMoveRule: RacingGameMoveRule
) {
    init {
        require(namesOfRacingCar.isNotEmpty()) { "자동차 이름은 1개 이상 존재해야 합니다." }
        require(numOfAttempts >= 1) { "시도 횟수는 1 이상이어야 합니다." }
    }

    fun start(): RacingGameResult {
        val resultOfRacingCars = namesOfRacingCar.map { RacingCar(it, racingGameMoveRule) }

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

        return RacingGameResult(racingCarGameRound, Winners(resultOfRacingCars))
    }

    companion object {
        const val START_ROUND = 1
    }
}
