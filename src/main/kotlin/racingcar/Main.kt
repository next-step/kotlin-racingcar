package racingcar

import racingcar.business.RacingGame
import racingcar.presentation.InBoundView
import racingcar.presentation.OutBoundView
import racingcar.utils.NumberGenerator
import racingcar.utils.RandomNumberGenerator

fun main() {
    val inBoundView = InBoundView({ requireNotNull(readLine()) }, ::print)
    val carNames: List<String> = inBoundView.requestCarNames()
    val numOfMove: Int = inBoundView.requestNumberOfMove()

    val random: NumberGenerator = RandomNumberGenerator()

    val racingGame = RacingGame(numOfMove, carNames, random)
    val result = racingGame.play()

    val outBoundView = OutBoundView(::print)
    outBoundView.displayResult(result)
}
