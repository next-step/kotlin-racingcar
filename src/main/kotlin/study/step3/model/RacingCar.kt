package study.step3.model

import study.step3.util.DigitNumber

private const val ADVANCE_BASE_DIGIT = 4

class RacingCar(
    numberCar: Int,
    private val repeatNumber: Int,
    private val digitNumber: DigitNumber
) {
    private var cars: MutableList<Car> = mutableListOf()

    init {
        require(numberCar > 0) { "참가 자동차 수는 0보다 커야 합니다" }
        settingCar(numberCar)
    }

    private fun settingCar(numberCar: Int) {
        (1..numberCar).forEach { _ ->
            cars.add(Car())
        }
    }

    fun race() {
        repeat(repeatNumber) {
            processRace()
        }
    }

    private fun processRace() {
        cars.forEach { car: Car ->
            if (digitNumber.getDigit() >= ADVANCE_BASE_DIGIT) {
                car.advance()
            } else {
                car.stop()
            }
        }
    }

    fun getCars(): List<Car> = cars.toList()
}
