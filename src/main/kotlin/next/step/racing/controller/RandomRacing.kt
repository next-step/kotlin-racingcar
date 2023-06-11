package next.step.racing.controller

import next.step.racing.domain.racing.Racing
import next.step.racing.util.DrivingStrategyUtil
import next.step.racing.view.InputView
import next.step.racing.view.OutputView

fun main() {

    runCatching {
        val carNames = InputView.readCarNames()
        val stepCnt = InputView.readStepCount()
        Racing.race(carNames, stepCnt, DrivingStrategyUtil.defaultRandom())
    }.onSuccess {
        OutputView.showResult(it)
    }.onFailure { e ->
        OutputView.showError(e.message)
        main()
    }
}
