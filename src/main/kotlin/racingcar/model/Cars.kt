package racingcar.model

class Cars(
    private var cars: List<Car>
) {

    fun moveForwardCars() {
        cars = cars.map {
            it.moveForward()
        }
    }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)
}
