package study.racinggame.controller

import study.racinggame.domain.Race
import study.racinggame.race.RaceRule
import study.racinggame.race.reader.InputReader
import study.racinggame.race.view.DrawView
import study.racinggame.race.view.InputView
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
