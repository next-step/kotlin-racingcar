package racing

import kotlin.random.Random

class CarRacing {

    fun run() {
        val input = RacingInputManager().receive()
        val ui = RacingUI()

        val cars = MutableList(input.carNumber) { Car() }

        repeat(input.moveCount) {
            cars.forEach {
                it.move(Random.nextInt(MAX_POWER))
            }
            ui.drawCars(cars)
        }
    }

    companion object {
        const val MAX_POWER = 10
    }
}