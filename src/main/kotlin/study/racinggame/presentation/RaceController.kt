package study.racinggame.presentation

import study.racinggame.domain.Race
import study.racinggame.presentation.view.DrawView
import study.racinggame.presentation.view.InputView
import study.racinggame.presentation.view.OutputFormat
import study.racinggame.reader.InputReader

class RaceController(
    inputReader: InputReader,
    private val outputFormat: OutputFormat = DrawView()
) {

    private val inputView = InputView().initInputView(inputReader)

    fun startRace() {
        val race = Race(inputView.carStorage())
        repeat(inputView.raceTryCnt()) { outputFormat.drawCarState(race.runTrack()) }
        outputFormat.drawRaceWinner(race.getRaceWinner())
    }
}
