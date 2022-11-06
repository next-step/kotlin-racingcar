package racingcar.application

import racingcar.racingcar.CarManager
import racingcar.racingcar.CarRacing
import racingcar.ui.InputView
import racingcar.ui.ResultView

class Application {
    private val carRacing = CarRacing(CarManager())

    private val inputView = InputView()
    private val resultView = ResultView()

    fun run() {
        println(GuideScript.PROGRAM_INFO)
        while (true) {
            println(GuideScript.BEGIN_GUIDE)
            val runCommand = readln()
            if (STOP_COMMAND == runCommand) {
                break
            }
            val carRacingRequest = inputView.getRequest()
            val carRacingResult = carRacing.participate(carRacingRequest)
            resultView.view(carRacingResult)
        }
        println(GuideScript.CLOSE_GUIDE)
    }

    companion object {
        private const val STOP_COMMAND = "0"
    }
}
