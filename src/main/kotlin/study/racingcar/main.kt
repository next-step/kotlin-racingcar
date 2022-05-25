package study.racingcar

import study.racingcar.controller.RacingController
import study.racingcar.service.RacingService

fun main() {
    val racingService = RacingService()
    val racingController = RacingController(racingService)
    racingController.startRace()
}
