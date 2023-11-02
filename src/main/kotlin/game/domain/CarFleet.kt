package game.domain

class CarFleet private constructor(
    var cars: List<Car> = listOf(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator(),
    private val winnerFinder: WinnerFinder = DefaultWinnerFinder()
) {

    fun advance(retryCount: Int): GameResult {
        var history = History()
        var carFleet = this
        repeat(retryCount) {
            carFleet = carFleet.advanceAll()
            history = history.addRound(carFleet.cars)
        }
        val winner = winnerFinder.findWinner(carFleet.cars)
        return GameResult(history, winner)
    }

    private fun advanceAll(): CarFleet {
        val carList = cars.map { car -> car.move(moveConditionGenerator.generate()) }
        return of(carList, moveConditionGenerator, winnerFinder)
    }

    companion object {
        fun of(
            cars: List<Car>,
            moveConditionGenerator: MoveConditionGenerator,
            winnerFinder: WinnerFinder
        ): CarFleet {
            return CarFleet(cars, moveConditionGenerator, winnerFinder)
        }

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
