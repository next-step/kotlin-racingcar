package racingCarWinner.domain

class RacingGame private constructor(
    val racingCars: List<Car>,
) {
    fun racing(): List<Car> {
        racingCars.forEach { it.move() }
        return racingCars
    }

    fun selectWinner(): List<String> {
        val maxLocation = racingCars.maxOf { it.location }
        val winnerCars = racingCars.filter { it.location == maxLocation }
        return winnerCars.map { it.name }
    }

    companion object {
        @JvmName("ofCarNames")
        fun of(carNames: List<String>): RacingGame {
            return RacingGame(
                racingCars = carNames.map {
                    Car.of(name = it)
                }
            )
        }

        @JvmName("ofCars")
        fun of(cars: List<Car>): RacingGame {
            return RacingGame(
                racingCars = cars
            )
        }
    }
}