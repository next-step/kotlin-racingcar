package racing.domain

import racing.view.OutPutView

class Game(
    private val roundCount: Int,
    private val carCount: Int,
    private val pedal: Pedal
) {
    fun start() {
        val cars = Cars.make(count = carCount, pedal = pedal)
        val round = Round.make(count = roundCount).round

        OutPutView.printStart()
        for (i in 0..round) {
            cars.goForward()
            OutPutView.printRound(cars)
        }
    }
}
