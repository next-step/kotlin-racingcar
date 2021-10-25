package racingcar.domain

import java.util.Random

class Circuit(carsNameList: List<String> = emptyList()) {
    private val circuit = ArrayList<Car>()

    private val randomGenerator = Random()

    init {
        addCarNameListToCircuit(carsNameList)
    }

    fun addCarToCircuit(car: Car) = circuit.add(car)

    fun tryToMoveAllCar() =
        circuit.forEach {
            it.moveToForward(getRandomValue())
        }

    fun getAllCarsLapResult() = circuit.map { LapResult(it.carName, it.movedDistance) }

    private fun getRandomValue(bound: Int = FIXED_BOUND) = randomGenerator.nextInt(bound)

    private fun addCarNameListToCircuit(carNameList: List<String>) {
        carNameList.forEach {
            addCarToCircuit(Car(4, it))
        }
    }

    companion object {
        private const val FIXED_BOUND = 10
    }
}
