package racingcar

import racingcar.business.RacingContext
import racingcar.presentation.InBoundView
import racingcar.presentation.OutBoundView
import racingcar.utils.RandomGenerator
import racingcar.utils.RandomGeneratorImpl

fun main() {
    val inBoundView = InBoundView(::readLine, ::print)
    val numOfPlayer: Int = inBoundView.requestNumberOfPlayer()
    val numOfMove: Int = inBoundView.requestNumberOfMove()

    val random: RandomGenerator = RandomGeneratorImpl()

    val racingContext = RacingContext(numOfPlayer, numOfMove, random)
    val result = racingContext.play()

    val outBoundView = OutBoundView(::print)
    outBoundView.displayResult(result)
}
