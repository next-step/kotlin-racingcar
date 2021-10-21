package racing.domain

import racing.view.OutPutView

class Game(
    private val round: Round,
    private val carNames: List<String>,
    private val pedal: Pedal
) {
    fun start() {
        val cars = Cars.make(carNames = carNames, pedal = pedal)

        OutPutView.printStart()
        for (i in 0..round.round) {
            cars.goForward()
            OutPutView.printRound(cars)
        }
    }
}
