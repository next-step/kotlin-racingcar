package racingcar

import racingcar.domain.Car
import racingcar.domain.Number
import racingcar.domain.strategy.RacingRuleStrategy

class Cars(
    number: Number,
) {
    companion object {
        private const val START_NUMBER = 1
    }

    private val _cars: List<Car> = IntRange(START_NUMBER, number.value)
        .map { Car(RacingRuleStrategy()) }
        .toList()

    val cars = _cars
}
