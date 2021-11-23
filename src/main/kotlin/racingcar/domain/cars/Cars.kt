package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Cars(
    private val racing: Racing = Racing(),
    private val racingDistance: RacingDistance = RacingDistance(),
    private val numberOfRacingCars: NumberOfRacingCars = NumberOfRacingCars(NUMBER_OF_DEFAULT_START_RACING_CARS)
) {
    private val cars: List<Car> = courseInRacingCars(numberOfRacingCars.value)

    val numberOfExistCars: Int
        get() = numberOfRacingCars.value

    val currentRacingLabs: List<Int>
        get() = cars.map { car ->
            car.racingDistance()
        }.toList()

    fun courseInRacingCars(numberOfRacingCars: Int): List<Car> {
        return List(numberOfRacingCars) {
            Car(
                racing = racing,
                racingDistance = racingDistance
            )
        }
    }

    fun races(engine: Engine) = cars.forEach { car ->
        car.race(engine)
    }

    companion object {
        private const val NUMBER_OF_DEFAULT_START_RACING_CARS = 1
    }
}
