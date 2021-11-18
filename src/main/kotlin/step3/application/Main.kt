package step3.application

import step3.domain.RaceManager
import step3.ui.InputView
import step3.ui.ResultView

/**
 *
 * @author Leo
 */
fun main() {

    val inputView = InputView()
    val participantCount = inputView.getParticipantCount()
    val totalCount = inputView.getTotalCount()

    val raceManager = RaceManager()
    val movingHistories =
        raceManager.startRace(totalCount = totalCount, cars = raceManager.getParticipants(participantCount))

    val resultView = ResultView()
    resultView.showRaceResult(totalCount = totalCount, movingHistories = movingHistories)

}
