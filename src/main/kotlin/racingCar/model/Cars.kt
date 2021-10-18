package racingCar.model

class Cars(numberOfCars: List<String>) {

    var list = List(numberOfCars.size) { Car() }

    fun move(distanceOfDrive: () -> Int) {
        list.map { moveCar(it, distanceOfDrive) }
    }

    private fun moveCar(car: Car, distanceOfDrive: () -> Int) = car.move(distanceOfDrive.invoke())
}
