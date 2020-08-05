package racingcar.domain.printer

import racingcar.domain.car.Car
import racingcar.domain.const.CAR_NAME_FORMAT
import racingcar.domain.const.GAME_RESULT
import racingcar.domain.const.UNDER_BAR
import racingcar.domain.result.RacingResult

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
