package racing

import racing.domain.CarRacing
import racing.view.InputView
import racing.view.ResultView

class CarRacingApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val (carNames, tryCount) = InputView.inputForRacing()
            val result = CarRacing().race(carNames, tryCount)
            ResultView.printRacingResult(result)
        }
    }
}
