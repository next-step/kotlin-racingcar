package racingcar.domain

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

    fun race(): List<Car> {
        val list = mutableListOf<Car>()
        for (car in _cars) {
            val speed = car.speedUp()
            car.drive(speed)
            list.add(car)
        }
        return list.toList()
    }
}
