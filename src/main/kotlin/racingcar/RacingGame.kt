package racingcar

import racingcar.domain.Car
import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    fun play() {
        val inputView = InputView()
        val resultView = ResultView()

        val cars = Car.generateCarByName(inputView.getCarNameByInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."))
        val race = Race(round = inputView.getRaceRoundByInput("시도할 횟수는 몇 회인가요?"))

        resultView.getRaceResult(race, cars)
    }

    private fun ResultView.getRaceResult(race: Race, cars: List<Car>) {
        this.printResultTitle()
        repeat(race.round) { this.printCarsInfo(race.run(cars)) }
        this.printWinner(race, cars)
    }
}
