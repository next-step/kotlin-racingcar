package racingCar.model

class Cars(stringOfCars: List<String>) {

    private val list = stringOfCars.map { Car(it) }

    fun move(distanceOfDrive: () -> Int) {
        list.forEach { moveCar(it, distanceOfDrive) }
    }

    private fun moveCar(car: Car, distanceOfDrive: () -> Int) = car.move(CarMoveAmount(distanceOfDrive.invoke()))

    fun result() = list.map { it.info() }

    fun victoryPlayer() = list.map { it.info() }
        .filter { it.second == maxResult() }
        .map { it.first }

    private fun maxResult() = list.maxOf { it.info().second }
}
