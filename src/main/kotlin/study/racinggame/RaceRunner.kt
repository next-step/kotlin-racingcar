package study.racinggame

import study.racinggame.domain.Race
import study.racinggame.race.RaceRule
import study.racinggame.race.reader.ActualInputReader
import study.racinggame.race.view.InputView

fun main() {
    val race = init()
    race.startRace()
}

fun init(): Race {
    val inputReader = ActualInputReader()
    val raceRule = RaceRule()
    val inputView = InputView().initInputView(inputReader)
    return Race(inputView, raceRule)
}
