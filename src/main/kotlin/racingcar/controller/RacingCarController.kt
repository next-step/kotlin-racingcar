package racingcar.controller

import racingcar.service.RacingCarService

class RacingCarController(private val racingCarService: RacingCarService) {
    fun start() {
        val numberCars = racingCarService.startNumberCars()
        val tryCount = racingCarService.startTryCount()
        racingCarService.startRace(numberCars, tryCount)
    }
}
