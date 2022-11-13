package racingcar.application

import racingcar.racingcar.CarManager
import racingcar.racingcar.CarRacing
import racingcar.racingcar.IndicatorGenerator
import racingcar.ui.InputView
import racingcar.ui.ResultView

class Application {
    private val carManager = CarManager(IndicatorGenerator())
    private val carRacing = CarRacing()

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
            val cars = carManager.ready(carRacingRequest.totalParticipants, carRacingRequest.turnCount)
            val carRacingResult = carRacing.participate(cars, carRacingRequest.turnCount)
            resultView.view(carRacingResult)
        }
        println(GuideScript.CLOSE_GUIDE)
    }

    companion object {
        private const val STOP_COMMAND = "0"
    }
}
