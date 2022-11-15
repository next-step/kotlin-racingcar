package study.racing

import study.racing.entity.Race
import study.racing.ui.InputView
import study.racing.ui.ResultView

fun main() {
    val carCount = InputView
        .CarCount(SystemValueProvider)
        .getCount()

    val roundCount = InputView
        .RoundCount(SystemValueProvider)
        .getCount()

    val race = Race(
        roundCount = roundCount,
        carCount = carCount,
        powerSource = RandomPowerSource()
    )
    race.start()

    ResultView(race).printResult()
}
