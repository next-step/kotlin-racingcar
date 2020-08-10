package racingcar.view

import racingcar.domain.CAR_NAME_FORMAT
import racingcar.domain.Car
import racingcar.domain.GAME_RESULT
import racingcar.domain.RacingResult
import racingcar.domain.UNDER_BAR

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
