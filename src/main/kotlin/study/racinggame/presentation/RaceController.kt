package study.racinggame.presentation

import study.racinggame.domain.Race
import study.racinggame.presentation.view.DrawView
import study.racinggame.presentation.view.InputView
import study.racinggame.service.RaceRule
import study.racinggame.service.reader.InputReader
import kotlin.random.Random

class RaceController(
    inputReader: InputReader,
    random: Random = Random
) {

    private val drawView: DrawView = DrawView()
    private val inputView = InputView().initInputView(inputReader)
    private val raceRule = RaceRule(random = random)

    fun startRace() {
        val race = Race(inputView.carStorage(), raceRule)
        repeat(inputView.raceTryCnt()) { drawView.drawCarState(race.runTrack()) }
        drawView.drawRaceWinner(race.getRaceWinner())
    }
}
