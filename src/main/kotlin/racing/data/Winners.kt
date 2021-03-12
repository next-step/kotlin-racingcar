package racing.data

import racing.domain.Car
import racing.domain.CarName

data class Winners(
    val winners: List<CarName>
) {
    fun joinWinnerNamesToString(delimeter: String): String {
        return winners.joinToString(delimeter) { it.value }
    }

    companion object {
        fun from(winnerCars: List<Car>): Winners {
            return Winners(winnerCars.map { it.name })
        }
    }
}
