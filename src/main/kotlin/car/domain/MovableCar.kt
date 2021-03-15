package car.domain

interface MovableCar {
    val currentPosition: Int
    val carName: CarName
    val historyCollection: CarMoveHistoryCollection

    fun move()
    fun isWinner(winnerPosition: Int): Boolean {
        return currentPosition == winnerPosition
    }
}
