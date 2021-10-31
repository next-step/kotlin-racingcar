package racingcar.ui

import racingcar.car.Car
import racingcar.constant.Message
import racingcar.util.Validation

object ResultView {
    fun printRacingResult(car: Car) {
        println("${car.name}: ${car.getLocation()}")
    }

    fun printRacingWinner(winnerList: List<String>) {
        print(String.format(Message.RESULT_WINNER, winnerList.joinToString(Validation.DELIMITER)))
    }
}
