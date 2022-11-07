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
    private val _results: MutableList<List<Car>> = mutableListOf()
    val results: List<List<Car>>
        get() = _results

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
            _results.add(raceCarResult)
            racingCarGarage.parkCars(raceCarResult)
        }
    }
}
