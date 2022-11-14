package racingcar.application

import racingcar.domain.carRacing.CarManager
import racingcar.domain.carRacing.CarRacing
import racingcar.domain.carIndicator.IndicatorGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class Application {
    private val carManager = CarManager()

    private val inputView = InputView()
    private val resultView = ResultView()

    private var run = true

    fun run() {
        println(GuideScript.PROGRAM_INFO)
        while (run) {
            val carRacingRequest = inputView.getRequest()
            val cars = carManager.ready(carRacingRequest.carNames)
            val carRacing = CarRacing(IndicatorGenerator(), carRacingRequest.turnCount, cars)
            carRacing.start()
            resultView.view(carRacing.result())

            println(GuideScript.BEGIN_GUIDE)
            val runCommand = readln()
            run = STOP_COMMAND != runCommand
        }
        println(GuideScript.CLOSE_GUIDE)
    }

    companion object {
        private const val STOP_COMMAND = "0"
    }
}
