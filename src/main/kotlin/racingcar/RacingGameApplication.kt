package racingcar

import racingcar.domain.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingGameApplication().run()
}

class RacingGameApplication(private val racingGame: RacingGame) {

    constructor() : this(
        racingGame = RacingGame(
            inputView = InputView(),
            outputView = OutputView()
        )
    )

    fun run() {
        racingGame.start()
    }
}
