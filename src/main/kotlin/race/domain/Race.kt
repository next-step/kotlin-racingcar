package race.domain

import race.ui.ResultView

class Race(val cars: List<Car>) {

    init {
        require(cars.isNotEmpty()) { "car is not empty."}
    }

    private fun turnAround(randomNumber: () -> Int) {
        cars.map { it.move(randomNumber()) }
        ResultView.printNow(cars)
        println()
    }

    fun start(lapCount: Int, randomNumber: () -> Int): Race {
        require(lapCount > 0) { "lap count is positive." }

        ResultView.printTitle()
        IntRange(1, lapCount).forEach { _ -> turnAround(randomNumber) }
        return this
    }

    fun takeWinners(): List<Car> {
        val winnerPosition = cars.map { it.position }.max()
        return cars.filter { it.position == winnerPosition }
    }
}
