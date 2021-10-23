package step3

import step3.RandomGenerator.getRandomValue

class Circuit {
    private val circuit = ArrayList<Car>()

    fun addCarToCircuit(car: Car) = circuit.add(car)
    fun tryToMoveAllCar() {
        circuit.forEach {
            val randomValue = getRandomValue()
            it.move(randomValue)
        }
    }

    fun getAllCarsMoveDistance() = circuit.map { it.getMovedDistance() }
}
