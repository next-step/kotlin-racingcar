package racingcar.domain

import java.lang.IllegalArgumentException

class Cars(
    countOfCars: Int
) {
    val values: List<Car>
    private val gasStation: GasStation = GasStation()

    init {
        validateMinCount(value = countOfCars)
        val values = mutableListOf<Car>()
        for (i in MIN_COUNT..countOfCars) values.add(Car())
        this.values = values
    }

    private fun validateMinCount(value: Int) {
        if (value < MIN_COUNT) {
            throw IllegalArgumentException("자동차 수는 $MIN_COUNT 이상이어야 합니다.")
        }
    }

    fun race() = values.forEach { car -> car.fillGasAndForward(gasStation.getRandomGas()) }

    companion object {
        const val MIN_COUNT = 1
    }
}
