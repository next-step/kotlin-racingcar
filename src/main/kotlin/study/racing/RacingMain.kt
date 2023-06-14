package study.racing

import study.racing.car.CarRanker
import study.racing.car.factory.NameBasedCarFactory
import study.racing.inputview.CarNameBasedInputView
import study.racing.movement.condition.RandomMovementConditionGenerator
import study.racing.renderer.StdoutRenderer
import study.racing.resultview.CarNameDisplayedResultView
import study.racing.resultview.RankedResultView

fun main() {
    val result = CarNameBasedInputView().receive()
    val carFactory =
        NameBasedCarFactory(result.carNames)
    val progressResultView = CarNameDisplayedResultView("-", StdoutRenderer())
    val rankedResultView = RankedResultView(StdoutRenderer())
    val racing =
        Racing(carFactory, RandomMovementConditionGenerator(), CarRanker(), progressResultView, rankedResultView)
    racing.start(result.numOfAttempt)
}
