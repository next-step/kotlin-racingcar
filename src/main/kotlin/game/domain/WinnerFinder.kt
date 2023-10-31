package game.domain

fun interface WinnerFinder {
    fun findWinner(cars: List<Car>): List<String>
}
