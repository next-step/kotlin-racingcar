package car.domain

class Winners(carMoveHistoryCollection: CarMoveHistoryCollection) {
    val winners: List<Winner>

    init {
        val maxPosition = carMoveHistoryCollection.moveHistories
            .map { it.position }
            .max()!!

        winners = carMoveHistoryCollection.moveHistories
            .filter { it.isWinner(maxPosition) }
            .map { Winner(it.carName) }
    }

    override fun toString(): String {
        return winners.joinToString(",") { toString() }
    }
}
