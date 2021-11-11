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
        val carNames = racingCarView.carNames()
        val lapCount = racingCarView.lapCount()
        val scoreboard = racingCarService.race(
            RacingCars.of(carNames, RandomMovingStrategy),
            Laps.of(lapCount)
        )
        racingCarView.showResult(ScoreboardConsoleDto(scoreboard))
    }
}
