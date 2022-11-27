package racingcar.domain

class RacingGame(val value: List<Car> = emptyList()) {

    fun racing(): RacingGame {
        var racingGame = RacingGame()
        value.forEach { car ->
            racingGame += car.move()
        }

        return racingGame
    }

    fun awardsCars(): List<Car> {
        return value.sortedBy { it.position.value }
    }

    private operator fun plus(car: Car): RacingGame {
        return RacingGame(value + car)
    }

    companion object {
        fun create(cars: List<Car>): RacingGame {
            return RacingGame(cars)
        }
    }

}