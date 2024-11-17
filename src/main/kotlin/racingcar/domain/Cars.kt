package racingcar.domain

class Cars(private val cars: List<Car>) {
    fun move(numberGenerator: NumberGenerator) {
        cars.forEach { it.moveOrStand(numberGenerator) }
    }

    fun makeCarsMovementTracker(): CarsMovementTracker {
        return CarsMovementTracker(cars)
    }

    fun recordPositions(carsMovementTracker: CarsMovementTracker) {
        cars.forEach { car -> carsMovementTracker.recordCarsPosition(car) }
    }

    fun findWinners(): Cars {
        val maxPositionCar = findMaxPositionCar()
        val winningCars = cars.filter { it.isSamePosition(maxPositionCar) }
        return Cars(winningCars)
    }

    private fun findMaxPositionCar() =
        cars.reduce { highest, current ->
            if (current.comparePosition(highest) > 0) {
                current
            } else {
                highest
            }
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
