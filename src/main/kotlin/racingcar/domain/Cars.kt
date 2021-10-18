package racingcar.domain

import racingcar.domain.strategy.RacingRuleStrategy

class Cars private constructor(
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

    fun findRacingWinners(): List<Name> {
        val maxPosition = findMaxPosition()
        return cars.filter { it.position.value == maxPosition }
            .map { it.name }
            .toList()
    }

    private fun findMaxPosition(): Int {
        val positions = cars.map { it.position.value }.toList()
        return positions.maxOrNull() ?: 0
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
