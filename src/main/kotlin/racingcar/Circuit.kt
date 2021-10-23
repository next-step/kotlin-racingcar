package racingcar

import racingcar.RandomGenerator.getRandomValue

class Circuit {
    private val circuit = ArrayList<Car>()

    fun addCarToCircuit(car: Car) = circuit.add(car)

    fun tryToMoveAllCar() =
        circuit.forEach {
            it.move(getRandomValue())
        }

    fun getAllCarsLapResult() = circuit.map { LapResult(it.carName, it.movedDistance) }
}
