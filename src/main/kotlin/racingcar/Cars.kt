package racingcar

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.filter { checkIsMovable(decideCarAction(numberGenerator)) }
            .forEach { it.move() }
    }

    private fun checkIsMovable(carAction: CarAction): Boolean {
        return carAction.isMove()
    }

    private fun decideCarAction(numberGenerator: NumberGenerator): CarAction {
        return CarAction.generate(numberGenerator.generate())
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
