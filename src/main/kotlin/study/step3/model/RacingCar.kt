package study.step3.model

import study.step3.util.DigitGenerator

class RacingCar(
    numberCar: Int,
    private val repeatNumber: Int,
    private val digitGenerator: DigitGenerator
) {
    private var cars: MutableList<Car> = mutableListOf()

    init {
        require(numberCar > 0) { "참가 자동차 수는 0보다 커야 합니다" }
        settingCar(numberCar)
    }

    private fun settingCar(numberCar: Int) {
        (1..numberCar).forEach { _ ->
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
