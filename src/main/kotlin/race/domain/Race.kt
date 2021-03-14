package race.domain

import race.ui.ResultView
import kotlin.random.Random

class Race(carNames: String, private val lapCount: Int) {
    val cars: List<Car> = carNames.split(delimeter).map { Car(it) }

    init {
        require(lapCount > 0) { "lap count is positive." }
    }

    private fun turnAround() {
        cars.map { it.move(Random.nextInt(0, 9)) }
        ResultView.printNow(cars)
        println()
    }

    fun start(): Race {
        ResultView.printTitle()
        IntRange(1, lapCount).forEach { _ -> turnAround() }
        return this
    }

    fun result() {
        val winnerPosition = cars.map { it.position }.max()
        val winner = cars.filter { it.position == winnerPosition }
        ResultView.printWinner(winner)
    }

    companion object {
        const val delimeter: String = ","
    }
}
