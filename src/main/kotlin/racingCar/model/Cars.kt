package racingCar.model

class Cars(stringOfCars: List<String>) {

    var list = stringOfCars.map { Car(it) }

    fun move(distanceOfDrive: () -> Int) {
        list.map { moveCar(it, distanceOfDrive) }
    }

    private fun moveCar(car: Car, distanceOfDrive: () -> Int) = car.move(distanceOfDrive.invoke())
}
