package racingcar.domain.car

class RacingCars private constructor(val cars: List<RacingCar>) {

    fun runCars() {
        cars.forEach { it.tryMove() }
    }

    companion object {
        fun of(racingCars: List<RacingCar>): RacingCars {
            return RacingCars(racingCars)
        }
    }
}
