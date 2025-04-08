package carracing.view

import carracing.Car


object ResultView {
    fun showStatus(cars: List<Car>) {
        cars.forEach {
            println("${it.name}: ${"-".repeat(it.position)}")
        }
    }

    fun displayWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(",") { it.name }
        println("Winners: $winnerNames")
    }
}
