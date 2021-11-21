package step4.application

import step4.domain.ForwardImpl
import step4.domain.RaceManager
import step4.ui.InputView
import step4.ui.ResultView

/**
 *
 * @author Leo
 */
fun main() {

    val inputView = InputView()
    val participantNames = inputView.getParticipantNames()
    val totalCount = inputView.getTotalCount()

    val raceManager = RaceManager(ForwardImpl())
    val movingHistories =
        raceManager.startRace(totalCount = totalCount, cars = raceManager.getParticipants(participantNames))

    val resultView = ResultView()
    resultView.showRaceResult(totalCount = totalCount, movingHistories = movingHistories)
    resultView.showWinners(raceManager.getWinnerNames(movingHistories).joinToString(", "))
}
