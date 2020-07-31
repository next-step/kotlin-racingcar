package racingcar.racing

import racingcar.racing.car.Car
import racingcar.racing.const.CAR_NUMBER_ERROR
import racingcar.racing.const.ERROR_CAR_NAME_OVERFLOW
import racingcar.racing.const.TURN_NUMBER_ERROR

class GameSetupHelper {
    fun askHowManyCars(input: String?): List<Car> {
        try {
            val names = input!!.split(",").map { it.trim() }
            return names.map { Car(it) }
        } catch (e: Car.NameLengthOverflowException) {
            throw RacingCarGame.SetupFailException(ERROR_CAR_NAME_OVERFLOW)
        } catch (e: Exception) {
            throw RacingCarGame.SetupFailException(CAR_NUMBER_ERROR)
        }
    }

    fun askHowManyTurns(input: String?): Int {
        try {
            return input?.toInt()!!
        } catch (e: Exception) {
            throw RacingCarGame.SetupFailException(TURN_NUMBER_ERROR)
        }
    }
}
