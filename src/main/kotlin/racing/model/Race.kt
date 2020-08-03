package racing.model

import racing.strategy.MoveStrategy

class Race(private val numberOfTrials: Int, cars: List<Car>) {
    private val _cars: List<Car> = cars.deepCopy()
    val cars: List<Car>
        get() = _cars.deepCopy()

    constructor(numberOfTrials: Int, carNames: String) : this(
        numberOfTrials,
        carNames.split(CAR_NAME_DELIMITER).map { Car(it, mutableListOf()) }
    )

    private fun List<Car>.deepCopy(): List<Car> = map { it.copy() }

    fun run(moveStrategy: MoveStrategy) {
        repeat(numberOfTrials) {
            makeTurn(moveStrategy)
        }
    }

    private fun makeTurn(strategy: MoveStrategy) {
        for (car in cars) {
            car.saveResultOfTurn(strategy.getResultOfTurn())
        }
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
