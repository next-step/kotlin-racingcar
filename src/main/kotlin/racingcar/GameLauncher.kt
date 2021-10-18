package racingcar

import racingcar.domain.RacingGame
import racingcar.service.CarMoveForwardDecider
import racingcar.service.CarMoveForwardRandomValueGetter
import racingcar.view.input.ConsoleInputView
import racingcar.view.result.ConsoleResultView

class GameLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RacingGame(
                ConsoleInputView(),
                ConsoleResultView(),
                CarMoveForwardDecider(CarMoveForwardRandomValueGetter())
            ).proceed()
        }
    }
}
