package racingcar.domain

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.forEach { it.moveOrStand(numberGenerator) }
    }

    fun getCarNames(): List<String> {
        return cars.map { it.getNameValue() }
    }

    fun getPositionValues(): List<Int> {
        return cars.map { it.getPositionValue() }
    }

    companion object {
        fun makeNewCars(nameInput: String): Cars {
            return Cars(
                nameInput.split(",")
                    .map { Car.makeNewCar(it) },
            )
        }
    }
}
