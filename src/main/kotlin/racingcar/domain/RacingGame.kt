package racingcar.domain

class RacingGame(val value: List<Car> = emptyList()) {

    fun racing(): RacingGame {
        var racingGame = RacingGame()
        value.forEach { car ->
            racingGame += car.move()
        }

        return racingGame
    }

    private operator fun plus(car: Car): RacingGame {
        return RacingGame(value + car)
    }

    companion object {
        fun startRacingGame(count: Int): RacingGame {
            var racingGame = RacingGame()
            repeat(count) {
                racingGame += Car()
            }

            return racingGame
        }
    }

}