package racingcar

import racingcar.domain.CarRace
import racingcar.domain.RaceStatus
import racingcar.view.ConsoleRaceInput
import racingcar.view.ConsoleRaceOutputViewer
import racingcar.view.RaceInput
import racingcar.view.RaceOutputViewer

class ConsoleRaceService {
    private val raceInput: RaceInput = ConsoleRaceInput()
    private val raceOutputViewer: RaceOutputViewer = ConsoleRaceOutputViewer()

    fun startCarRace() {
        with(raceInput.input()) {
            CarRace(this).run {
                raceStatus().view()
                while (!finished()) {
                    doRace().view()
                }
            }
        }
    }

    private fun RaceStatus.view() {
        raceOutputViewer.view(this)
    }
}
