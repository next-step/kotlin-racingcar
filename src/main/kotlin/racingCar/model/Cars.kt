package racingCar.model

class Cars(stringOfCars: List<String>) {

    private val list = stringOfCars.map { Car(it) }

    fun move() {
        list.forEach { moveCar(it) }
    }

    private fun moveCar(car: Car) = car.move(CarMove())

    fun result() = list.map { it.info() }

    fun victoryPlayer() = list.map { it.info() }
        .filter { it.second == maxResult() }
        .map { it.first }

    private fun maxResult() = list.maxOf { it.info().second }
}
