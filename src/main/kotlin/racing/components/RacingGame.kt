package racing.components

class RacingGame(carCount: Int, var movementChecker: MovementChecker) {

    var carList: MutableList<Car> = mutableListOf()

    init {
        for (i in 1..carCount) {
            carList.add(Car())
        }
    }

    fun moveAllCar() {
        carList.forEach { moveCarIfPossible(it) }
    }

    private fun moveCarIfPossible(car: Car) {
        if (movementChecker.goodToMove()) {
            car.moveCar()
        }
    }

    fun getCarPositions(): List<Int> {
        return carList.map { it.position }
    }
}
