package racingcar

import racingcar.controller.RacingCarController
import racingcar.service.RacingCarService

object RacingCarApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        val racingCarService = RacingCarService()
        val racingCarController = RacingCarController(racingCarService)
        racingCarController.start()
    }
}
