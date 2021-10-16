package racingcar

class GameLauncher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            RacingGame(ConsoleInputView(), ConsoleResultView(), RandomCarMoveForwardStrategy()).proceed()
        }
    }
}
