package racingcar.domain

import racingcar.domain.RandomGenerator.getRandomValue

class Circuit(carsNameList: List<String> = emptyList()) {
    private val circuit = ArrayList<Car>()

    init {
        addCarNameListToCircuit(carsNameList)
    }

    fun addCarToCircuit(car: Car) = circuit.add(car)

    fun tryToMoveAllCar() =
        circuit.forEach {
            it.moveToForward(getRandomValue())
        }

    fun getAllCarsLapResult() = circuit.map { LapResult(it.carName, it.movedDistance) }

    private fun addCarNameListToCircuit(carNameList: List<String>) {
        carNameList.forEach {
            addCarToCircuit(Car(4, it))
        }
    }
}
