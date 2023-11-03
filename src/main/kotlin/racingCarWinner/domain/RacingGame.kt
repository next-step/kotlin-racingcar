package racingCarWinner.domain

class RacingGame private constructor(
    val numOfAttempts: Int,
    val racingCars: List<Car>,
) {
    fun start(): List<Car> {
        racingCars.forEach { it.move() }
        return racingCars
    }

    fun selectWinner(): List<String> {
        val maxLocation = racingCars.maxOf { it.location }
        val winnerCars = racingCars.filter { it.location == maxLocation }
        return winnerCars.map { it.name }
    }

    companion object {
        fun of(carNames: List<String>, numOfAttempts: Int): RacingGame {
            return RacingGame(
                racingCars = carNames.map {
                    Car.of(name = it)
                },
                numOfAttempts = numOfAttempts
            )
        }
    }
}