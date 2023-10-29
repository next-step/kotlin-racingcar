package game

class UserMessageDisplay : UserOutputHandler {

    override fun display(cars: List<Car>) {
        cars.forEach(::display)
        println()
    }

    private fun display(car: Car) = println(car.draw())

    override fun displayWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }
}
