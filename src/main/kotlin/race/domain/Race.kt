package race.domain

class Race(val cars: List<Car>, val randomNumber: () -> Int) {

    init {
        require(cars.isNotEmpty()) { "car is not empty."}
    }

    private fun turnAround() {
        cars.map { it.move(randomNumber()) }
    }

    fun start(lapCount: Int, printNow: (List<Car>) -> Unit) {
        require(lapCount > 0) { "lap count is positive." }

        repeat(lapCount) {
            turnAround()
            printNow(cars)
        }
    }

    fun takeWinners(): List<Car> {
        val winnerPosition = cars.map { it.position }.max()
        return cars.filter { it.position == winnerPosition }
    }
}
