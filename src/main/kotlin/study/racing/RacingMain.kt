package study.racing

import study.racing.car.CarRanker
import study.racing.car.factory.NameBasedCarListFactory
import study.racing.inputview.CarNameBasedInputView
import study.racing.movement.condition.DefaultMovementCondition
import study.racing.renderer.StdoutRenderer
import study.racing.resultview.RacingResultView

fun main() {
    val result = CarNameBasedInputView().receive()
    val CarListFactory =
        NameBasedCarListFactory(result.carNames)
    val resultView = RacingResultView("-", StdoutRenderer())
    val racing =
        Racing(CarListFactory, CarRanker(), DefaultMovementCondition(), resultView)
    racing.start(result.numOfAttempt)
}
