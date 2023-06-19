package racingcar.domain.car

import racingcar.domain.racing.RacingCondition

data class CarList(
    val cars: List<Car>
) {

    fun race(racingCondition: RacingCondition) {
        cars.forEach { car -> car.race(racingCondition) }
    }

    fun getWinner(): CarList {
        val maxPosition = cars.maxOf { it.position }
        return CarList(cars.filter { it.position == maxPosition })
    }

    override fun toString(): String {
        return cars.joinToString { it.name }
    }

    companion object {

        fun of(carNames: String) =
            CarList(
                cars = CarNameParser.parse(carNames).map { carName -> Car(carName) }
            )
    }
}
