package racingcar

import racingcar.domain.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceGame(private val inputView: InputView, private val resultView: OutputView) {

    fun run() {
        val carCount = inputView.carCount
        val tryCount = inputView.tryCount
        val race = Race(carCount)

        println("실행 결과")

        repeat((0 until tryCount).count()) {
            race.run()
            resultView.show(race.movingDistances)
        }
    }
}
