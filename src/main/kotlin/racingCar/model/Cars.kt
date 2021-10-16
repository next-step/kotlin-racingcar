package racingCar.model

class Cars(numberOfCars: Int, private val distanceOfDrive: () -> Int = { 0 }) {

    var list = List(numberOfCars) { Car() }

    fun move() {
        list = list.map { moveCar(it) }
    }

    private fun moveCar(car: Car) = car.move(distanceOfDrive.invoke())

}
