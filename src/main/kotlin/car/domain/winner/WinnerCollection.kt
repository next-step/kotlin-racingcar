package car.domain.winner

import car.domain.CarCollection

class WinnerCollection(carCollection: CarCollection) {
    val winners: List<Winner> = carCollection
        .winners
        .map { Winner(it.carName) }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
