package racingcar

import racingcar.model.Participants
import racingcar.strategy.MovingStrategy
import racingcar.view.ResultView

class RacingGame(
    private val carCount: Int,
    private val tryCount: Int,
    private val movingStrategy: MovingStrategy
) {
    private val participants = Participants(carCount, movingStrategy)

    fun execute() {
        for (i in 0 until tryCount) {
            participants.processRound()
            ResultView.printParticipantsPath(participants)
        }
    }
}
