package car.domain.winner

import car.domain.history.CarMoveHistories

data class Winners(private val carMoveHistories: CarMoveHistories) {
    val winners: List<Winner>
        get() = winners()

    private fun winners(): List<Winner> {
        return carMoveHistories.filter {
            it.position >= carMoveHistories.maxPosition
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
