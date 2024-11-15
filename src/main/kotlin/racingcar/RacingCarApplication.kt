package racingcar

import racingcar.controller.RacingCarController

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val racingCarController = RacingCarController()
        racingCarController.start()
    }
}
