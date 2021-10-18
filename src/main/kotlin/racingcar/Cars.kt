package racingcar

class Cars private constructor(private val racingCars: List<Car>) {

    companion object {
        fun from(numberOfCars: NumberOfCars): Cars {
            val racingCars = (1..numberOfCars.value)
                .map { carNumber -> Car(carNumber) }
                .toList()

            return Cars(racingCars)
        }
    }

    fun goForward(carMoveForwardDecider: CarMoveForwardDecider) {
        racingCars
            .forEach { car -> car.moveForward(carMoveForwardDecider) }
    }

    fun getCars(): List<Car> {
        return racingCars.toList()
    }
}
