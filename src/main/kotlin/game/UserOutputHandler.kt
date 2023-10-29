package game

interface UserOutputHandler {
    fun displayWinners(winners: List<String>)
    fun displayHistory(history: History)
}
