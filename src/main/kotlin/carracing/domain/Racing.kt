package carracing.domain

import carracing.ui.OutputView
import kotlin.random.Random

const val MAX_SIZE: Int = 9
const val CAR_SYMBOL = "-"

class Racing(var cars: List<Car>, var attemptCount: Int) {

    fun race() {
        for (round in 1..attemptCount) {
            movingCar()
        }
    }

    private fun movingCar() {
        for (value in cars.indices) {
            cars[value].move(Random.nextInt(MAX_SIZE))
            println(CAR_SYMBOL.repeat(cars[value].position))
        }
        OutputView.lineChange()
    }
}
