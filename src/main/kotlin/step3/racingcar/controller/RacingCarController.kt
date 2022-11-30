package step3.racingcar.controller

import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.service.RacingCarService
import step3.racingcar.utils.CarGenerator
import step3.racingcar.utils.RandomNumberGenerator
import step3.racingcar.view.InputView.Companion.inputJoinerCarsGuideMessagePrinter
import step3.racingcar.view.InputView.Companion.inputRoundCountGuideMessagePrinter
import step3.racingcar.view.ResultView

class RacingCarController {
    private val racingCarService: RacingCarService = RacingCarService(RandomNumberGenerator())

    fun gameStart() {
        val carNames = inputJoinerCarsGuideMessagePrinter()
        val totalRound = inputRoundCountGuideMessagePrinter()
        val cars = Cars.of(CarGenerator.generate(carNames))
        val playInfo = PlayInfo(cars, totalRound)
        val playResult = racingCarService.play(playInfo)
        ResultView.printResult(playResult)
    }
}
