package racingcar

import racingcar.component.RacingcarGameContext
import racingcar.model.RacingcarGameInput
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGame {
    fun play() {
        val input = RacingcarGameInputView.getInput()

        val manager = createRacingcarGameContext(input)

        println("실행 결과")

        for (round: Int in 0..input.roundNumber) {
            manager.doRound()
            RacingcarGameResultView.printCarsDistance(manager.cars)
        }
    }

    private fun createRacingcarGameContext(input: RacingcarGameInput): RacingcarGameContext {
        return RacingcarGameContext.create(input)
    }
}
