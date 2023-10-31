package racingcar

import racingcar.component.RacingcarGameContext
import racingcar.model.RacingcarGameInput
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGame {
    fun play() {
        val input = RacingcarGameInputView.getInput()

        val manager = createRacingcarGameContext(input)

        RacingcarGameResultView.printGameStart()

        repeat(input.roundNumber) {
            manager.doRound()
            RacingcarGameResultView.printCarsDistance(manager.cars)
        }
    }

    private fun createRacingcarGameContext(input: RacingcarGameInput): RacingcarGameContext {
        return RacingcarGameContext.create(input)
    }
}
