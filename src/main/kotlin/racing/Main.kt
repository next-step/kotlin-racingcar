package racing

import racing.domain.Game
import racing.domain.Pedal
import racing.view.InputView

fun main() {
    val car = InputView.getCar()
    val round = InputView.getRound()
    val game = Game(carCount = car, roundCount = round, pedal = Pedal(4))
    game.start()
}
