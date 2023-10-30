package racingcar

import racingcar.component.RacingcarGameManager
import racingcar.model.RacingcarGameInput
import racingcar.view.RacingcarGameInputView
import racingcar.view.RacingcarGameResultView

class RacingcarGameApplication {
    fun play() {
        val input = inputView.getInput()

        val manager = createRacingcarGameManager(input)

        println("실행 결과")

        for (round: Int in 0..input.roundNumber) {
            manager.doRound()
            resultView.printCarsDistance(manager.cars)
        }
    }

    private fun createRacingcarGameManager(input: RacingcarGameInput): RacingcarGameManager {
        return RacingcarGameManager.create(input)
    }

    companion object {
        private val inputView: RacingcarGameInputView = RacingcarGameInputView()
        private val resultView: RacingcarGameResultView = RacingcarGameResultView()
    }
}

fun main() {
    val application = RacingcarGameApplication()

    application.play()
}
