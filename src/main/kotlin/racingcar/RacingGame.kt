package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    fun play() {
        val inputView = InputView()
        val resultView = ResultView()

        val cars = Car.generateCar(count = inputView.getCarCountByInput("자동차 대수는 몇 대인가요?"))
        val race = Race(round = inputView.getRaceRoundByInput("시도할 횟수는 몇 회인가요?"))

        resultView.printRaceResult(race, cars)
    }
}
