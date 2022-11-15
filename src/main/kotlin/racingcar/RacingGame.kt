package racingcar

import racingcar.controller.Controller

class RacingGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Controller().start()
        }
    }
}
