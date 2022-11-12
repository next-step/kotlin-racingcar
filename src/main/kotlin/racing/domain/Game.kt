package racing.domain

import racing.view.GameOutputView

class Game(val cars: List<Car>, private val round: Int = 3) {

    fun play() {
        GameOutputView.printStartGame()
        for (i in 0 until round) {
            race()
            GameOutputView.printRaceStatus(cars)
            GameOutputView.printNextRound()
        }
        GameOutputView.printRaceWinner(getWinner(cars))
    }

    fun getWinner(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { car -> car.position }
        return cars.filter { car -> car.position == maxPosition }
    }

    private fun race() {
        cars.forEach {
            it.move()
        }
    }
}
