package study.racingcar.controller

import study.racingcar.dto.RoundResultResponse
import study.racingcar.entity.Car
import study.racingcar.service.RacingService

class RacingCarController(
    private val racingService: RacingService,
) {
    fun initCarNames(carNames: Set<String>) {
        racingService.intCars(carNames)
    }

    fun start(gameCount: Int): List<RoundResultResponse> {
        return racingService.getGameResultByRound(gameCount)
    }

    fun getWinners(): List<Car> {
        return racingService.getWinners()
    }
}
