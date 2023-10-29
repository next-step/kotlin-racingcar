package game

class CarFleet private constructor(
    private val _cars: List<Car>,
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator(),
) {
    private val cars: List<Car>
        get() = _cars.toList()

    fun findWinner(): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }

    fun advance(retryCount: Int): History {
        var history = History()
        repeat(retryCount) {
            advanceAll()
            history.addRound(cars)
        }
        history.setWinners(findWinner())
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
    }
}
