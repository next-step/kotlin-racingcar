package study.racing

import study.racing.data.RandomPowerSource
import study.racing.domain.entity.Race
import study.racing.domain.entity.RacingCar
import study.racing.domain.repository.RacingCarRepositoryImpl
import study.racing.view.InputView
import study.racing.view.ResultView

fun main() {
    val carNames = InputView
        .CarName
        .getNames()

    val roundCount = InputView
        .RoundCount
        .getCount()

    val race = Race(
        roundCount = roundCount,
        cars = carNames.map { name ->
            RacingCar(
                name = name,
                repo = RacingCarRepositoryImpl(RandomPowerSource()),
            )
        }
    )
    race.start()

    ResultView(race).printResult()
}
