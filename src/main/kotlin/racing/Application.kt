package racing

import racing.Infrastructure.RacingCar
import racing.domain.RacingState
import racing.util.CarUtil
import racing.presentation.InputView
import racing.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputNames = InputView().inputNames()
        val attempt = InputView().inputAttempt()

        CarUtil.validate(inputNames, attempt)

        val names = CarUtil.splitNames(inputNames!!)

        val racingState = RacingState(names, attempt!!.toInt())
        val result = RacingCar().start(racingState)

        val winners = RacingCar().getWinner(result)
        ResultView().view(result)
    }
}
