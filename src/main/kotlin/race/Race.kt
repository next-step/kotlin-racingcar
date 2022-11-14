package race

class Race {
    private val randomGeneratorNumber = RandomGeneratorNumber()
    private val THRESHOLD = 4
    fun start(carCount: Int, tryCount: Int): List<Car> {
        var cars = List(carCount) { Car() }
        for (i in 1..tryCount) {
            moveCars(cars)
        }
        return cars
    }

    private fun moveCars(cars: List<Car>) =
        repeat(cars.size) { index ->
            cars[index]
            val randomNumber = randomGeneratorNumber.generate()
            val moveCondition = randomNumber >= THRESHOLD
            cars[index].move(moveCondition)
        }
}
