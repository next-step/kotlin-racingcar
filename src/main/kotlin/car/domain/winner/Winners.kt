package car.domain.winner

import car.domain.Position
import car.domain.history.CarMoveHistories

data class Winners(private val carMoveHistories: CarMoveHistories) {
    val winners: List<Winner>
        get() = winners()

    private fun winners(): List<Winner> {
        val winnersPosition = carMoveHistories.map {
            it.position.value
        }.max() ?: 0

        return carMoveHistories.filter {
            it.position >= Position(winnersPosition)
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
