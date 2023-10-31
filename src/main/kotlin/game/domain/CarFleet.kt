package game.domain

class CarFleet private constructor(
    private val _cars: List<Car>,
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator(),
    private val winnerFinder: WinnerFinder = DefaultWinnerFinder()
) {
    val cars: List<Car>
        get() = _cars.toList()

    fun advance(retryCount: Int): History {
        var history = History()
        repeat(retryCount) {
            advanceAll()
            history = history.addRound(cars)
        }
        val winner = winnerFinder.findWinner(cars)
        history = history.setWinners(winner)
        return history
    }

    private fun advanceAll() {
        _cars.forEach { car -> car.move(moveConditionGenerator.generate()) }
    }

    companion object {
        fun of(carNames: List<String>, moveConditionGenerator: MoveConditionGenerator): CarFleet {
            return CarFleet(carNames.map { Car.of(it) }, moveConditionGenerator)
        }

        fun from(cars: List<Car>, moveConditionGenerator: MoveConditionGenerator): CarFleet {
            return CarFleet(cars, moveConditionGenerator)
        }

        fun of(cars: List<Car>): CarFleet {
            return CarFleet(cars)
        }
    }
}
