package racing

import racing.domain.GoOrStopCarAction
import racing.domain.RacingCarsFactory
import racing.model.Car
import racing.model.CarCount
import racing.model.RoundCount

class RacingGame(
    private val carCount: CarCount,
    private val roundCount: RoundCount,
    private val goOrStopCarAction: GoOrStopCarAction,
    private val racingCarsFactory: RacingCarsFactory,
) {
    data class RacingCar(
        val cars: List<Car>
    )

    private var racingCar: RacingCar = RacingCar(racingCarsFactory.createCars(carCount.value))
    private val results: MutableList<List<Car>> = mutableListOf()

    fun play() {
        val roundCount = this.roundCount.value
        for (i in 0 until roundCount) {
            val cars = this.racingCar.cars
            val result = cars.map {
                val action = goOrStopCarAction.castCarAction()
                it.copy(mileage = it.mileage + action.value)
            }
            results.add(result)
            racingCar = RacingCar(cars = result.map { it.copy() })
        }
        println("$results")
    }
}
