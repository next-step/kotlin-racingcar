package racing.model

import racing.strategy.MoveStrategy

class Race {
    private var numberOfTrials = 0
    private var cars = listOf<Car>()

    fun initiate(trials: Int, names: String) {
        numberOfTrials = trials
        cars = getCars(names)
    }

    fun getCars(): List<Car> {
        return cars
    }

    fun run(moveStrategy: MoveStrategy) {
        repeat(numberOfTrials) {
            makeTurn(moveStrategy)
        }
    }

    private fun getCars(names: String): List<Car> {
        val carNames = names.split(CAR_NAME_DELIMITER)

        return carNames.map { Car(it, 0, mutableListOf()) }
    }

    private fun makeTurn(strategy: MoveStrategy) {
        for (car in cars) {
            car.save(strategy.getResultOfTurn())
        }
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
