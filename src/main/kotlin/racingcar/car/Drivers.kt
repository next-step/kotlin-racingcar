package racingcar.car

import racingcar.car.strategy.MoveStrategy
import racingcar.car.strategy.NameLengthLimitStrategy
import racingcar.car.strategy.NameStrategy

class Drivers(
    private val carNames: List<String>,
    private val moveStrategy: MoveStrategy,
    nameStrategy: NameStrategy = NameLengthLimitStrategy()
) {
    init {
        carNames.forEach { nameStrategy.validateName(it) }
    }

    private val cars: List<Car> = List(carNames.size) { Car(carNames[it]) }

    fun driveAll() {
        cars.filter { moveStrategy.isMovable() }
            .forEach { car -> car.move() }
    }

    fun getMoveResult(): MoveResults {
        return MoveResults(cars.map { it.moveResult })
    }
}
