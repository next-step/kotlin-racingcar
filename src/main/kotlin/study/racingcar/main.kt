package study.racingcar

import study.racingcar.controller.RacingController
import study.racingcar.repository.impl.RoundMemoryRepositoryImpl
import study.racingcar.service.RacingService

fun main() {
    val racingService = RacingService(RoundMemoryRepositoryImpl())
    val racingController = RacingController(racingService)
    racingController.startRace()
}
