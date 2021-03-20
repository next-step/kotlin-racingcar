package car.domain.winner

import car.domain.Cars

class Winners(private val cars: Cars) {
    val winners: List<Winner>
        get() = getWinnersInCars()

    private fun getWinnersInCars(): List<Winner> {
        val maxPosition = cars.maxPosition

        return cars.filter {
            it.position == maxPosition
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
