package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.interfaces.CarTrackView
import camp.nextstep.edu.racingcar.racing.Car

class CommandLineInterface {

    fun draw(carTrackView: CarTrackView, to: Int) {
        println(carTrackView.traces(to))
    }

    fun drawWinner(winners: List<Car>) {
        print("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    fun drawBlank() = println()
}
