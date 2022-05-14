package racingcar.controller

import racingcar.constants.Message
import racingcar.model.Car
import racingcar.model.RaceResult

/**
 * 레이싱을 시작하고, 계산하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingController(carNames: List<String>) {
    private val cars: List<Car> = List(carNames.size) { Car(carNames[it]) }
    private val _raceResults: MutableList<RaceResult> = mutableListOf()
    val raceResults: List<RaceResult>
        get() = _raceResults.toList()

    fun startGame(repeatTimes: Int) {
        checkNumberCanBeProcessed(repeatTimes)
        repeat(repeatTimes) {
            processGame()
            _raceResults.add(RaceResult(cars))
        }
    }

    private fun checkNumberCanBeProcessed(number: Int) {
        require(number >= CAN_VALID_NUMBER) { Message.ExceptionMessage.ENTERED_INVALID_NUMBER }
    }

    private fun processGame() {
        cars.forEach { car ->
            if (checkCanRunScore(rollTheDice())) {
                car.advanceOnce()
            }
        }
    }

    private fun rollTheDice(): Int {
        return (MINIMUM_SCORE..MAXIMUM_SCORE).random()
    }

    private fun checkCanRunScore(score: Int): Boolean {
        return score >= SCORE_OF_CAN_GO
    }

    companion object {
        private const val MINIMUM_SCORE = 0
        private const val MAXIMUM_SCORE = 9
        private const val SCORE_OF_CAN_GO = 4
        private const val CAN_VALID_NUMBER = 1
    }
}
