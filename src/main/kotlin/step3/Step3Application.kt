package step3

import step3.UI.InputView

fun main () {
    val carRacing = CarRacing.of(InputView.writeCarCount(), InputView.writeMoveCount())
    carRacing.run(MovingStrategyRandom())
}