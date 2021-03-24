package car.domain.winner

import car.domain.history.CarMoveHistories

data class Winners(private val carMoveHistories: CarMoveHistories) {
    val winners: List<Winner> = getWinnersInCarMoveHistories()

    private fun getWinnersInCarMoveHistories(): List<Winner> {
        return carMoveHistories.filter {
            it.position >= carMoveHistories.maxPosition
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(WINNERS_JOIN_STRING)
    }

    companion object {
        private const val WINNERS_JOIN_STRING = ","
    }
}
