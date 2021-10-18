package racingcar

import racingcar.service.CarMoveForwardDecider
import racingcar.service.CarMoveForwardRandomValueGetter

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
