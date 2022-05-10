package racing

import kotlin.random.Random

class CarRacing(private val carMaxPower: Int = DEFAULT_MAX_POWER) {

    private val inputReceiver = RacingInputReceiver()
    private val ui = RacingUI()

    fun run() {
        val input = inputReceiver.receive()
        val cars = MutableList(input.carNumber) { Car() }

        play(cars, input.moveCount)
    }

    private fun play(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) {
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
