package racing

import racing.domain.Game
import racing.domain.Pedal
import racing.domain.Round
import racing.view.InputView

fun main() {
    val carNames = InputView.getCar()
    val round = Round.make(InputView.getRound())
    val game = Game(carNames = carNames, round = round, pedal = Pedal(4))
    game.start()
}
