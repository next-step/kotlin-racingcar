package racingcar

class Cars(numberOfCars: NumberOfCars, private val carMoveForwardDecider: CarMoveForwardDecider) {
    private var racingCars: List<Car> = ArrayList()

    init {
        racingCars = (1..numberOfCars.value!!)
            .map { carNumber -> Car(carNumber) }
            .toList()
    }

    fun goForward() {
        racingCars
            .forEach { car -> car.moveForward(carMoveForwardDecider) }
    }

    fun getCars(): List<Car> {
        return this.racingCars
    }
}
