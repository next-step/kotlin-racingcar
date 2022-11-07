package racing

import racing.domain.GoOrStopCarAction
import racing.model.Car
import racing.model.CarCount
import racing.model.RoundCount

class RacingGame(
    private val carCount: CarCount,
    private val roundCount: RoundCount,
    private val racingCarGarage: RacingCarGarage,
    private val goOrStopCarAction: GoOrStopCarAction,
) {
    val results: MutableList<List<Car>> = mutableListOf()

    fun race() {
        val roundCount = this.roundCount.value
        for (i in 0 until roundCount) {
            val cars = if (racingCarGarage.shouldCreateCars()) {
                racingCarGarage.createCars(carCount)
            } else racingCarGarage.cars

            val raceCarResult = cars.map {
                val action = goOrStopCarAction.castCarAction()
                it.copy(mileage = it.mileage + action.value)
            }
            results.add(raceCarResult)
            racingCarGarage.parkCars(raceCarResult)
        }
        println("$results")
    }
}
