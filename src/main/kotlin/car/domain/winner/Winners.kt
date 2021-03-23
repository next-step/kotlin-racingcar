package car.domain.winner

import car.domain.Cars
import car.domain.Position

class Winners(private val cars: Cars) {
    val winners: List<Winner>
        get() = getWinnersInCars()

    private fun getWinnersInCars(): List<Winner> {
        val winnersPosition = cars.maxPosition

        return cars.filter {
            it.position >= Position(winnersPosition)
        }.map {
            Winner(it.carName)
        }
    }

    override fun toString(): String {
        return winners.joinToString(",")
    }
}
