package step4.model

import step4.strategy.MoveStrategy

data class Race(val names: String) {
    private val cars = getCars(names)

    private fun getCars(names: String): MutableList<Car> {
        val carNames = names.split(CAR_NAME_DELIMITER)
        val carList = ArrayList<Car>()

        for (carName in carNames) {
            carList.add(Car(carName, 0, mutableListOf()))
        }
        return carList
    }

    fun makeTurn(strategy: MoveStrategy) {
        for (car in cars) {
            val resultOfTurn = strategy.resultOfTurn
            car.saveResult(resultOfTurn)
        }
    }

    fun getCars(): List<Car> {
        return cars
    }

    companion object {
        private const val CAR_NAME_DELIMITER = ","
    }
}
