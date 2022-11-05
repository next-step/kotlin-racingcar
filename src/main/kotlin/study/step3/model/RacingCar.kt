package study.step3.model

import study.step3.util.randomDigit

class RacingCar(numberCar: Int, private val repeatNumber: Int) {
    private var cars: MutableList<Car> = mutableListOf()

    init {
        require(numberCar > 0) { "참가 자동차 수는 0보다 커야 합니다" }

        (1..numberCar).forEach { _ ->
            cars.add(Car())
        }
    }

    fun race() {
        repeat(repeatNumber) {
            cars.forEach { car: Car -> car.advance(randomDigit()) }
        }
    }

    fun cars(): List<Car> = cars.toList()
}
