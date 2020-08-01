package racing.model

import racing.strategy.MoveStrategy

class Race {
    private var numberOfTrials = 0
    private var cars = mutableListOf<Car>()

    fun initiate(trials: Int, names: String) {
        numberOfTrials = trials
        cars = getCars(names)
    }

    fun getCars(): List<Car> {
        return cars
    }

    fun start(moveStrategy: MoveStrategy) {
        repeat(numberOfTrials) {
            makeTurn(moveStrategy)
        }
    }

    private fun getCars(names: String): MutableList<Car> {
        val carNames = names.split(CAR_NAME_DELIMITER)
        val carList = ArrayList<Car>()

        for (carName in carNames) {
            carList.add(Car(carName, 0, mutableListOf()))
        }
        return carList
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
