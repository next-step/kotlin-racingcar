package racingcar.domain.cars

import racingcar.domain.engine.Engine

class RacingCars(racingCarList: List<RacingCar>) {
    private val courseInRacingCarList: List<RacingCar> = racingCarList.map { it.copyRacingCar() }

    val numberOfExistCars: Int
        get() = courseInRacingCarList.size

    val currentRacingDistances: List<Int>
        get() = courseInRacingCarList.map { car ->
            car.racingDistance()
        }

    init {
        require(racingCarList.size > MINIMUM_CAR_NAME_SIZE)
    }

    fun copyRacingCars(): List<RacingCar> = courseInRacingCarList.map { it.copyRacingCar() }

    fun races(engine: Engine) = courseInRacingCarList.forEach { car ->
        car.race(engine)
    }

    companion object {
        private const val MINIMUM_CAR_NAME_SIZE = 0
    }
}
