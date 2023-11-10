package racing

import racing.domain.CarRacing
import racing.domain.CarRacingCondition
import racing.domain.CarRacingConditionImpl
import racing.domain.CarRacingRecordStrategy
import racing.domain.CarRacingRecorder
import racing.view.InputView
import racing.view.ResultView

class CarRacingApplication {
    companion object {
        private val condition: CarRacingCondition = CarRacingConditionImpl
        private val recorder: CarRacingRecordStrategy = CarRacingRecorder

        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val result = CarRacing.of(condition, recorder, carNames).race(tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
