package racingcar.controller

import racingcar.constants.Message
import racingcar.domain.Car
import racingcar.domain.Dice
import racingcar.domain.RaceResult

/**
 * 레이싱을 시작하고, 계산하는 클래스
 * Created by Jaesungchi on 2022.05.07..
 */
class RacingController(private val cars: List<Car>) {
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
            // TODO : 차량이 전진 가능한지 따로 메소드를 빼자.
            if (Dice.fromRandom().isCanRunScore()) {
                car.advanceOnce()
            }
        }
    }

    companion object {
        private const val CAN_VALID_NUMBER = 1

        fun from(carNames: List<String>): RacingController {
            return RacingController(List(carNames.size) { Car(carNames[it]) })
        }
    }
}
