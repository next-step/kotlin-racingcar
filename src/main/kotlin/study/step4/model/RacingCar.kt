package study.step4.model

import study.step4.util.DigitGenerator

class RacingCar(
    racingCarNames: List<String>,
    private val repeatNumber: Int,
    private val digitGenerator: DigitGenerator
) {
    private var cars: MutableList<Car> = mutableListOf()

    init {
        require(racingCarNames.isNotEmpty()) { "참가 자동차 수는 0보다 커야 합니다" }
        settingCar(racingCarNames)
    }

    private fun settingCar(numberCar: List<String>) {
        numberCar.forEach { _ ->
            cars.add(Car(digitGenerator = digitGenerator))
        }
    }

    fun race() {
        repeat(repeatNumber) {
            processRace()
        }
    }

    private fun processRace() {
        cars.forEach { car: Car ->
            car.move()
        }
    }

    fun getCars(): List<Car> = cars.toList()
}
