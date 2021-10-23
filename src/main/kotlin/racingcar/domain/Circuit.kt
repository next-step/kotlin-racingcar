package racingcar.domain

import racingcar.domain.RandomGenerator.getRandomValue

class Circuit(carsNameList: List<String>? = null) {
    private val circuit = ArrayList<Car>()

    init {
        carsNameList?.let { addCarNameListToCircuit(it) }
    }

    fun addCarToCircuit(car: Car) = circuit.add(car)

    fun tryToMoveAllCar() =
        circuit.forEach {
            it.move(getRandomValue())
        }

    fun getAllCarsLapResult() = circuit.map { LapResult(it.carName, it.movedDistance) }

    private fun addCarNameListToCircuit(carNameList: List<String>) {
        carNameList.forEach {
            addCarToCircuit(Car(4, it))
        }
    }
}
