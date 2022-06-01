package racingcar.domain

import racingcar.domain.strategy.MoveStrategy
import racingcar.domain.strategy.NameStrategy
import racingcar.dto.MoveResults

class Drivers(
    private val carNames: List<String>,
    nameStrategy: NameStrategy
) {
    init {
        carNames.forEach { nameStrategy.validateName(it) }
    }

    private val cars: List<Car> = List(carNames.size) { Car(carNames[it]) }

    fun driveAll(moveStrategy: MoveStrategy) {
        cars.filter { moveStrategy.isMovable() }
            .forEach { car -> car.move() }
    }

    fun getWinnerResults(): MoveResults {
        val farthestDistance = cars.maxOf { it.moveResult.moveDistance }
        val moveResult = cars
            .filter { it.moveResult.moveDistance == farthestDistance }
            .map { it.moveResult }
        return MoveResults(moveResult)
    }

    fun getMoveResults(): MoveResults {
        return MoveResults(cars.map { it.moveResult })
    }
}
