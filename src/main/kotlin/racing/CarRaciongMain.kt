package racing

import racing.controller.RacingCarController
import racing.service.RacingCarService

fun main() {
    val racingCarService = RacingCarService()
    RacingCarController(racingCarService).startRacingGame()
}
