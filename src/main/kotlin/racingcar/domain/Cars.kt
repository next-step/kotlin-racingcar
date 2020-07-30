package racingcar.domain

import kotlin.math.max

class Cars(private var cars: List<Car>) {
    fun findWinners(): Winners {
        val maxPosition = getMaxPosition()
        return Winners(cars.filter { it.isWinner(maxPosition) })
    }

    private fun getMaxPosition(): Int = cars.maxBy { it.position }!!.position

    fun race() {
        this.cars = this.cars.map { it.move(randomNumber()) }
    }

    private fun randomNumber(): Int = (0..9).random()

    override fun toString(): String {
        val sb = StringBuilder()
        for (car in cars) {
            sb.append(car.toString())
            sb.append(System.lineSeparator())
        }
        return sb.toString()
    }
}
