package racing.data

import racing.domain.Car

data class Winners(
    val winners: List<String>
) {
    companion object {
        fun from(winnerCars: List<Car>): Winners {
            return Winners(winnerCars.map { it.name.name })
        }
    }
}
