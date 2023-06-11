package next.step.racing.controller

import next.step.racing.service.InputDevice
import next.step.racing.service.OutputDevice
import next.step.racing.service.Racing
import next.step.racing.util.DrivingStrategyUtil

fun main() {

    runCatching {
        val carNames = InputDevice.readCarNames()
        val stepCnt = InputDevice.readStepCount()
        Racing.race(carNames, stepCnt, DrivingStrategyUtil.defaultRandom())
    }.onSuccess {
        OutputDevice.showResult(it)
    }.onFailure { e ->
        OutputDevice.showError(e.message)
        main()
    }
}
