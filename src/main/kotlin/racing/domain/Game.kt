package racing.domain

import racing.view.OutPutView

class Game(
    private val round: Round,
    private val carNames: List<String>,
    private val pedal: Pedal
) {
    fun start() {
        val cars = Cars.make(carNames = carNames)

        OutPutView.printStart()
        for (i in 1..round.round) {
            cars.goForward(pedal)
            OutPutView.printRound(cars)
        }
        OutPutView.printResult(cars)
    }
}
