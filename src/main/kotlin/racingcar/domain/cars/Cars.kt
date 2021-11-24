package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class Cars(
    private val carsNames: List<String>,
    private val racing: Racing = Racing(),
    private val racingDistance: RacingDistance = RacingDistance()
) {
    private var cars: List<Car> = courseInRacingCars(carNames = carsNames)

    init {
        require(carsNames.size > MINIMUM_CAR_NAME_SIZE)
    }

    val numberOfExistCars: Int
        get() = cars.size

    val currentRacingLabs: List<Int>
        get() = cars.map { car ->
            car.racingDistance()
        }.toList()

    fun courseInRacingCars(carNames: List<String>): List<Car> {
        return carNames.map {
            Car(name = it, racing = racing, racingDistance = racingDistance)
        }
    }

    fun races(engine: Engine) = cars.forEach { car ->
        car.race(engine)
    }

    fun mapCarList(): List<Car> {
        return cars.map {
            Car(
                name = it.name,
                racing = racing,
                racingDistance = RacingDistance(it.racingDistance())
            )
        }
    }

    companion object {
        private const val MINIMUM_CAR_NAME_SIZE = 0
    }
}
