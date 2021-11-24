package racingcar.domain.cars

import racingcar.domain.engine.Engine
import racingcar.domain.racing.Racing
import racingcar.domain.racing.RacingDistance

data class RacingCars(
    private val carsNames: List<String>,
    private val racing: Racing = Racing(),
    private val racingDistance: RacingDistance = RacingDistance()
) {
    private var racingCars: List<RacingCar> = courseInRacingCars(carNames = carsNames)

    init {
        require(carsNames.size > MINIMUM_CAR_NAME_SIZE)
    }

    val numberOfExistCars: Int
        get() = racingCars.size

    val currentRacingLabs: List<Int>
        get() = racingCars.map { car ->
            car.racingDistance()
        }.toList()

    fun courseInRacingCars(carNames: List<String>): List<RacingCar> {
        return carNames.map {
            RacingCar(name = it, racing = racing, racingDistance = racingDistance)
        }
    }

    fun races(engine: Engine) = racingCars.forEach { car ->
        car.race(engine)
    }

    fun mapCarList(): List<RacingCar> {
        return racingCars.map {
            RacingCar(
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
