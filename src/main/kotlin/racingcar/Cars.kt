package racingcar

class Cars(numberOfCars: NumberOfCars) {
    private var racingCars: List<Car> = ArrayList()

    init {
        racingCars = (1..numberOfCars.value!!)
            .map { carNumber -> Car(carNumber) }
            .toList()
    }

    fun goForward(carMoveForwardStrategy: CarMoveForwardStrategy) {
        racingCars
            .forEach { car -> car.goForward(carMoveForwardStrategy) }
    }

    fun getCars(): List<Car> {
        return this.racingCars
    }
}
