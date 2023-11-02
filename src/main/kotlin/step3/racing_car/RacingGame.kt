package step3.racing_car

import step3.racing_car.interfaces.Movable
import step3.racing_car.model.Car

/**
 * 자동차 경주 게임
 * */
const val MIN_RANDOM_VALUE = 0
const val MAX_RANDOM_VALUE = 9

object RacingGame {

    /**
     * 게임 시작
     * @param elements first: 자동차 대수, seconds: 라운드 횟수, third: Movable 타입의 객체
     * */
    fun run(elements: Triple<String, String, (List<Movable>) -> Unit>) {

        errorCheck(elements.first)
        errorCheck(elements.second)

        var carList: List<Movable> = List(elements.first.toInt()) { Car() }

        repeat(elements.second.toInt()) {
            carList = playRound(carList)
            elements.third(carList)
        }
    }

    private fun errorCheck(inputStr: String?) {
        require(inputStr?.isNotEmpty() == true && Int.MAX_VALUE.toString().length >= inputStr.length && inputStr.toIntOrNull() != null && inputStr.toInt() > 0) {
            "Invalid Expression: $inputStr"
        }
    }

    private fun playRound(carList: List<Movable>): List<Movable> {
        return carList.map {
            it.move((MIN_RANDOM_VALUE..MAX_RANDOM_VALUE).random())
            it
        }
    }
}