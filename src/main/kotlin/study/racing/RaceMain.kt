package study.racing

import study.racing.entity.Race
import study.racing.ui.InputView
import study.racing.ui.ResultView

fun main() {
    val carCount = InputView
        .CarCount(SystemCountProvider)
        .getCount()

    val roundCount = InputView
        .RoundCount(SystemCountProvider)
        .getCount()

    val race = Race(
        roundCount = roundCount,
        carCount = carCount,
    )
    race.start()

    ResultView(race).printResult()
}
