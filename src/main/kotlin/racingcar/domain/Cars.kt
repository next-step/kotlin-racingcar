package racingcar.domain

import racingcar.domain.strategy.RacingRuleStrategy

class Cars(
    val cars: List<Car>,
) {
    fun race(): List<Car> {
        val raceResults = mutableListOf<Car>()
        for (car in cars) {
            val speed = RacingRuleStrategy.speedUp()
            car.drive(speed)
            raceResults.add(car)
        }
        return raceResults.toList()
    }

    companion object {
        private const val START_NUMBER = 0

        fun register(names: Names): Cars {
            val cars = (START_NUMBER until names.names.size)
                .map { Car(RacingRuleStrategy(), names.names[it]) }
            return Cars(cars)
        }
    }
}
