package racingcar.racing.printer

import racingcar.racing.car.Car
import racingcar.racing.const.CAR_NAME_FORMAT
import racingcar.racing.const.GAME_RESULT
import racingcar.racing.const.UNDER_BAR
import racingcar.racing.result.RacingResult

class ResultPrinter {
    fun resultToString(results: List<RacingResult>): String {
        return results.joinToString(
            prefix = "\n$GAME_RESULT\n",
            separator = "\n"
        ) {
            it.cars.map { car ->
                carName(car)
            }.joinToString(separator = "\n", postfix = "\n") {
                it
            }
        }
    }

    fun carName(car: Car) = String.format(CAR_NAME_FORMAT, car.name, UNDER_BAR.repeat(car.distance))
}
