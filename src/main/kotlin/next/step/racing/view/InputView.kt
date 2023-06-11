package next.step.racing.view

import next.step.racing.domain.car.CarNames
import next.step.racing.domain.racing.StepCount

object InputView {

    private const val ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    private const val ENTER_STEP_COUNT = "시도할 횟수는 몇 회인가요?"

    fun readCarNames(): CarNames = read(ENTER_CAR_NAMES, CarNames::from)

    fun readStepCount(): StepCount = read(ENTER_STEP_COUNT, StepCount::from)

    private fun <T> read(enterMsg: String, constructor: (String) -> T): T {
        return try {
            println(enterMsg)
            constructor(readln())
        } catch (e: Exception) {
            OutputView.showError(e.message)
            read(enterMsg, constructor)
        }
    }
}
