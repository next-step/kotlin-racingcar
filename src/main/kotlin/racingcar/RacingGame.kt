package racingcar

import racingcar.car.Car
import racingcar.car.Cars

class RacingGame(
    private val cars: Cars,
    private val rounds: Int,
) {
    private val gameResult = mutableListOf<RaceResult>()

    constructor(
        numberOfCars: Int,
        rounds: Int,
    ) : this(
        Cars(List(numberOfCars) { Car() }),
        rounds,
    )

    fun start() {
        repeat(rounds) {
            cars.moveAll()
            val roundResult = RaceResult(cars.getPositions())
            gameResult.add(roundResult)
        }
    }

    fun getResult() = gameResult.toList()
}
