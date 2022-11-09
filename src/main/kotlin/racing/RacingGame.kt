package racing

import racing.domain.GoOrStopCarAction
import racing.model.Car
import racing.model.RoundCount

class RacingGame(
    private val roundCount: RoundCount,
    private val racingCarGarage: RacingCarGarage,
    private val goOrStopCarAction: GoOrStopCarAction,
) {
    private val _results: MutableList<List<Car>> = mutableListOf()
    val results: List<List<Car>>
        get() = _results

    fun race() {
        val roundCount = this.roundCount.value
        repeat(roundCount) {
            val cars = racingCarGarage.cars

            val raceCarResult = cars.map {
                val action = goOrStopCarAction.castCarAction()
                it.copy(mileage = it.mileage + action.value)
            }
            _results.add(raceCarResult)
            racingCarGarage.parkCars(raceCarResult)
        }
    }
}
