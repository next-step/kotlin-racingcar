package racing.domain

import racing.view.OutPutView

object RacingController {
    fun printStart() {
        OutPutView.printStart()
    }

    fun printRound(cars: Cars) {
        OutPutView.printRound(cars)
    }

    fun printResult(cars: Cars) {
        OutPutView.printResult(cars)
    }

    fun race(cars: Cars, pedal: Pedal) {
        cars.goForward(pedal)
    }
}
