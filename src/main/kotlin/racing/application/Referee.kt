package racing.application

import racing.model.Car

object Referee {

    fun judge(cars: List<Car>): List<Car> {
        val sortedCars = cars.sortedByDescending { it.position }
        return sortedCars.filter { isWinner(sortedCars, it) }
    }

    private fun isWinner(sortedCarsDesc: List<Car>, targetCar: Car): Boolean =
        sortedCarsDesc.first().position.length == targetCar.position.length
}