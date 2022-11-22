package study.racing

import study.racing.domain.entity.Race
import study.racing.domain.entity.RacingCar
import study.racing.domain.repository.RacingCarRepository
import study.racing.ui.InputView
import study.racing.ui.ResultView

fun main() {
    val carNames = InputView
        .CarName(SystemValueProvider)
        .getNames()

    val roundCount = InputView
        .RoundCount(SystemValueProvider)
        .getCount()

    val race = Race(
        roundCount = roundCount,
        cars = carNames.map { name ->
            RacingCar(
                name = name,
                repo = RacingCarRepository(RandomPowerSource()),
            )
        }
    )
    race.start()

    ResultView(race).printResult()
}
