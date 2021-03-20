package car.domain.winner

import car.domain.CarCollection

class WinnerCollection(private val carCollection: CarCollection) {
    val winners: List<Winner>
        get() = getWinnersInCarCollection()

    private fun getWinnersInCarCollection(): List<Winner> {
        val maxPosition = carCollection.maxPosition

        return carCollection.filter {
            it.position == maxPosition
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
