package racing

import kotlin.random.Random

class CarRacing(private val carMaxPower: Int = DEFAULT_MAX_POWER) {

    fun run() {
        val input = RacingInputReceiver().receive()
        val ui = RacingUI()

        val cars = MutableList(input.carNumber) { Car() }

        repeat(input.moveCount) {
            cars.forEach {
                it.move(Random.nextInt(carMaxPower))
            }
            ui.drawCars(cars)
        }
    }

    companion object {
        private const val DEFAULT_MAX_POWER = 10
    }
}