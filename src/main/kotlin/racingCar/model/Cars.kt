package racingCar.model

class Cars(numberOfCars: Int) {

    var list = List(numberOfCars) { Car() }

    fun move(distanceOfDrive: () -> Int) {
        list.map { moveCar(it, distanceOfDrive) }
    }

    private fun moveCar(car: Car, distanceOfDrive: () -> Int) = car.move(distanceOfDrive.invoke())
}
