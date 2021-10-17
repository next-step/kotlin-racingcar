package racingcar.domain

import racingcar.domain.strategy.RacingRuleStrategy

class Cars(
    number: Number,
) {
    companion object {
        private const val START_NUMBER = 1
    }

    val cars: List<Car> = IntRange(START_NUMBER, number.value)
        .map { Car(RacingRuleStrategy()) }
        .toList()

    fun race(): List<Car> {
        val raceResults = mutableListOf<Car>()
        for (car in cars) {
            val speed = RacingRuleStrategy.speedUp()
            car.drive(speed)
            raceResults.add(car)
        }
        return raceResults.toList()
    }
}
