package racing

import kotlin.random.Random

class CarRacing(private val carMaxPower: Int = DEFAULT_MAX_POWER) {

    private val inputReceiver = RacingInputReceiver()
    private val ui = RacingUI()

    fun run() {
        val input = inputReceiver.receive()
        val cars = input.carNames.map { Car(it) }

        play(cars, input.moveCount)

        ui.drawWinners(findWinners(cars))
    }

    private fun play(cars: List<Car>, moveCount: Int) {
        repeat(moveCount) {
            cars.forEach {
                it.move(Random.nextInt(carMaxPower))
            }
            ui.drawCars(cars)
        }
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { maxPosition == it.position }
    }

    companion object {
        private const val DEFAULT_MAX_POWER = 10
    }
}
