package racingcar

import racingcar.model.Participants
import racingcar.strategy.MovingStrategy
import racingcar.view.ResultView

class RacingGame(
    private val carNames: String,
    private val tryCount: Int,
    private val movingStrategy: MovingStrategy
) {
    private val participants = Participants(carNames, movingStrategy)

    fun start() {
        for (i in 0 until tryCount) {
            participants.processRound()
            ResultView.printParticipantsPath(participants)
        }
    }
}
