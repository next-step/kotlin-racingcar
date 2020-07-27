package racing

import racing.Infrastructure.RacingCar
import racing.domain.RacingState
import racing.util.CarUtil
import racing.presentation.InputView
import racing.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        // val racingState = InputView().input()
        val carNumber = InputView().inputCarNumber()
        val attempt = InputView().inputAttempt()

        CarUtil.validate(carNumber, attempt)

        val racingState = RacingState(carNumber!!.toInt(), attempt!!.toInt())
        val result = RacingCar().start(racingState)

        ResultView().view(result)
    }
}
