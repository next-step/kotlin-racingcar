package racingcar.domain

import racingcar.dto.MoveResults

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

    fun getMoveResults(): MoveResults {
        return MoveResults(cars.map { it.moveResult })
    }
}
