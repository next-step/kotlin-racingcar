package racingcar.domain

import racingcar.domain.random.RandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

class CarRacing(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val randomGenerator: RandomGenerator = RandomGenerator(),
) {

    fun start() {

        val carNameList: List<String> = inputView.inputCarName()
        val racingCount = inputView.inputNumberOfAttempts()

        val racingCar = RacingCar(carNameList.map { Car(it) })

        for (i in 0 until racingCount) {
            racingCar.carAction(randomGenerator, resultView)
        }

        resultView.victoryCar(racingCar.victoryCar())
    }
}
