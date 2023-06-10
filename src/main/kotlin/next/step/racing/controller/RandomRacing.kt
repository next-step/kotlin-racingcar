package next.step.racing.controller

import next.step.racing.service.DrivingStrategyUtil
import next.step.racing.service.InputDevice
import next.step.racing.service.OutputDevice
import next.step.racing.service.Racing

fun main() {
    runCatching {
        val carCnt = InputDevice.readCarCount()
        val stepCnt = InputDevice.readStepCount()
        Racing.race(carCnt.cnt, stepCnt.cnt, DrivingStrategyUtil.defaultRandom())
    }.onSuccess {
        OutputDevice.showResult(it)
    }.onFailure { e ->
        OutputDevice.showError(e.message)
        main()
    }
}
