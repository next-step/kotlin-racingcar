package car_racing

class Game(
    numCar: Int,
    private val numMovement: Int,
) {

    private val cars: List<Car> = (1..numCar).map { Car() }

    private fun runRound() {
        this.cars.forEach {
            val randomValue: Int = RandomGenerator.value()
            if (randomValue >= 4) it.move()
        }
        ResultView.printRound(cars)
    }

    fun run() {
        (1..this.numMovement).forEach { _ ->
            this.runRound()
        }
    }
}
