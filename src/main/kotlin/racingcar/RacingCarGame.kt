package racingcar

import racingcar.service.RacingCarGameService
import racingcar.ui.InputView
import racingcar.ui.ResultView
import racingcar.util.RandomNumGenerator

fun main() {
    val countOfRacer = InputView.inputCountOfRacer()
    val countOfRacing = InputView.inputCountOfRacing()

    val racingCarGameService = RacingCarGameService()
    racingCarGameService.init(countOfRacer)

    ResultView.printInitMessage()
    val randomNumGenerator = RandomNumGenerator()
    repeat(countOfRacing) {
        racingCarGameService.race(randomNumGenerator)
        ResultView.printResult(racingCarGameService.racers)
    }
}
