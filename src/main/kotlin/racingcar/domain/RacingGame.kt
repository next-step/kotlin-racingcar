package racingcar.domain

import racingcar.constants.Message

/**
 * 게임을 진행하는 도메인 클래스
 * Created by Jaesungchi on 2022.05.16..
 */
class RacingGame(
    private val cars: List<Car>,
    private val repeatTimes: Int
) {
    init {
        checkNumberCanBeProcessed(repeatTimes)
    }

    fun startGame(): List<RaceResult> {
        val raceResults: MutableList<RaceResult> = mutableListOf()
        repeat(repeatTimes) {
            processGame()
            raceResults.add(RaceResult(cars))
        }
        return raceResults
    }

    private fun checkNumberCanBeProcessed(number: Int) {
        require(number >= CAN_VALID_NUMBER) { Message.ExceptionMessage.ENTERED_INVALID_NUMBER }
    }

    private fun processGame() {
        cars.forEach { car ->
            car.playOneRound()
        }
    }

    companion object {
        private const val CAN_VALID_NUMBER = 1
    }
}
