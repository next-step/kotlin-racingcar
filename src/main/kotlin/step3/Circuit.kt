package step3

import step3.RandomGenerator.getRandomValue

class Circuit {
    private var circuit = ArrayList<Car>()

    fun addCarToCircuit(car: Car) = circuit.add(car)
    fun tryToMoveAllCar() {
        circuit.forEach {
            val randomValue = getRandomValue()
            if (it.isMoveAble(randomValue)) {
                it.move()
            }
        }
    }
    fun getAllCarsMoveDistance() = circuit.map { it.movedDistance }
}
