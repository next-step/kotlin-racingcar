package racingcar.view

import racingcar.domain.car.Car
import racingcar.domain.const.CAR_NUMBER_ERROR
import racingcar.domain.const.ERROR_CAR_NAME_OVERFLOW
import racingcar.domain.const.HOW_MANY_CAR
import racingcar.domain.const.HOW_MANY_TURN
import racingcar.domain.const.TURN_NUMBER_ERROR

class InputView {
    fun askHowManyCars(): List<Car> {
        val cars = input(HOW_MANY_CAR)
        try {
            val names = cars!!.split(",").map { it.trim() }
            return names.map { Car(it) }
        } catch (e: Car.NameLengthOverflowException) {
            throw SetupFailException(ERROR_CAR_NAME_OVERFLOW)
        } catch (e: Exception) {
            throw SetupFailException(CAR_NUMBER_ERROR)
        }
    }

    fun askHowManyTurns(): Int {
        val turns = input(HOW_MANY_TURN)
        try {
            return turns?.toInt()!!
        } catch (e: Exception) {
            throw SetupFailException(TURN_NUMBER_ERROR)
        }
    }

    fun input(message: String?): String? {
        if (message != null) {
            println(message)
        }
        return readLine()
    }

    class SetupFailException(override val message: String) : Exception()
}
