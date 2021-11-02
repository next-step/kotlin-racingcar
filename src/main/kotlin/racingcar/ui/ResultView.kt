package racingcar.ui

import racingcar.car.Car
import racingcar.constant.Constant
import racingcar.constant.Message
import racingcar.util.Validation

object ResultView {
    private const val DISTANCE_CHARACTER = "-"

    private fun getDistanceOnScreen(distance: Int): String {
        var location = Constant.EMPTY
        repeat(distance) { location += DISTANCE_CHARACTER }
        return location
    }

    fun printRacingResult(car: Car) {
        println("${car.name}: ${getDistanceOnScreen(car.distance)}")
    }

    fun printRacingWinner(winnerList: List<String>) {
        print(String.format(Message.RESULT_WINNER, winnerList.joinToString(Validation.DELIMITER)))
    }
}
