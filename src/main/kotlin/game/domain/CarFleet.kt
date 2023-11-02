package game.domain

class CarFleet private constructor(
    val cars: List<Car> = listOf(),
    private val moveConditionGenerator: MoveConditionGenerator = RandomMoveConditionGenerator(),
    private val winnerFinder: WinnerFinder = DefaultWinnerFinder()
) {

    fun advanceAll(): CarFleet {
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

        fun of(cars: List<Car>): CarFleet {
            return CarFleet(cars)
        }
    }
}
