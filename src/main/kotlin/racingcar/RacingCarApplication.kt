package racingcar

import racingcar.domain.RacingCars
import racingcar.domain.strategy.RandomMovingStrategy
import racingcar.domain.vo.Laps
import racingcar.dto.ScoreboardConsoleDto
import racingcar.service.RacingCarService
import racingcar.service.SimpleRacingCarService
import racingcar.ui.RacingCarView
import racingcar.ui.SimpleRacingCarView

fun main() {
    RacingCarApplication(
        racingCarView = SimpleRacingCarView,
        racingCarService = SimpleRacingCarService()
    ).run()
}

class RacingCarApplication(
    private val racingCarView: RacingCarView,
    private val racingCarService: RacingCarService
) {
    fun run() {
        val carCount = racingCarView.carCount()
        val lapCount = racingCarView.lapCount()
        val scoreboard = racingCarService.race(
            RacingCars.of(carCount, RandomMovingStrategy),
            Laps.of(lapCount)
        )
        racingCarView.showResult(ScoreboardConsoleDto(scoreboard))
    }
}
