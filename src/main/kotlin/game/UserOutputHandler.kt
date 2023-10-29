package game

interface UserOutputHandler {
    fun display(cars: List<Car>)
    fun displayWinners(winners: List<String>)
    fun displayHistory(history: History)
}
