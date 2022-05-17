package racing.application

import racing.model.Car
import racing.model.Round

object Referee {

    fun judge(finalRound: Round): List<Car> {
        val sortedCars = finalRound.cars
            .sortedByDescending { it.position }
        return sortedCars.filter { isWinner(sortedCars, it) }
    }

    private fun isWinner(sortedCarsDesc: List<Car>, targetCar: Car): Boolean =
        sortedCarsDesc.first().position.length == targetCar.position.length
}
