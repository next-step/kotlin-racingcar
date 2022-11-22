package racingcar.domain

class RacingGame(val value: List<Car> = emptyList()) {

    fun racing(): RacingGame {
        var racingGame = RacingGame()
        value.forEach { car ->
            racingGame += car.move()
        }

        return racingGame
    }

    fun awardsCars(): List<String> {
        return value.groupBy {
            val max = value.maxOf { it.position.value }
            it.position.value == max
        }[true]?.map { it.name } ?: value.map { it.name }
    }

    private operator fun plus(car: Car): RacingGame {
        return RacingGame(value + car)
    }

    companion object {
        fun create(names: List<String>): RacingGame {
            var racingGame = RacingGame()
            names.forEach { name ->
                racingGame += Car(name)
            }

            return racingGame
        }
    }

}