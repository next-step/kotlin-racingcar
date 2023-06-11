class RacingField(
    val cars: MutableList<Car> = mutableListOf(),
    private var gameCount: Int = 0
) {
    private val resultView = ResultView()

    fun createCars(count: Int) {
        for (i in 1..count) {
            cars.add(Car())
        }
    }

    fun setGameCount(count: Int) {
        gameCount = count
    }

    fun gameStart() {
        resultView.resultMessage()

        for (i in 1..gameCount) {
            moveCars()
            resultView.carDistanceDisplay(cars)
        }
    }

    private fun moveCars() {
        cars.forEach { it.move() }
    }
}
