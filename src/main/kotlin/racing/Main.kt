package racing

import racing.condition.FirstRoundCondition
import racing.condition.RandomCondition
import racing.model.RacingGame
import racing.view.input.CarInputView
import racing.view.input.TotalRoundInputView
import racing.view.result.BasicCarResultView

fun main() {
    val carCount = CarInputView().value
    val totalRound = TotalRoundInputView().value
    val conditions = listOf(FirstRoundCondition(), RandomCondition())

    val racingGame = RacingGame(carCount, totalRound, conditions)
    racingGame.startRacing(BasicCarResultView())
}
