package step3.racingcar.controller

import step3.racingcar.domain.Cars
import step3.racingcar.domain.PlayInfo
import step3.racingcar.service.RacingCarService
import step3.racingcar.utils.CarGenerator
import step3.racingcar.utils.RandomNumberGenerator.generateRandomNumberToCarByRound
import step3.racingcar.view.InputView.Companion.inputCarCountGuideMessagePrinter
import step3.racingcar.view.InputView.Companion.inputRoundCountGuideMessagePrinter

class RacingCarController {
    private val racingCarService: RacingCarService = RacingCarService()

    fun gameStart() {
        val numberOfCars = inputCarCountGuideMessagePrinter()
        val totalRound = inputRoundCountGuideMessagePrinter()
        val cars = Cars.of(CarGenerator.generate(numberOfCars))
        generateRandomNumberToCarByRound(cars, totalRound)
        val playInfo = PlayInfo(cars, totalRound)
        racingCarService.play(playInfo)
    }
}
