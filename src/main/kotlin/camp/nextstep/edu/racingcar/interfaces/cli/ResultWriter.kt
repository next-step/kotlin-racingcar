package camp.nextstep.edu.racingcar.interfaces.cli

import camp.nextstep.edu.racingcar.interfaces.CarTrackView
import camp.nextstep.edu.racingcar.racing.Car

object ResultWriter {

    fun writeResult(carTrackView: CarTrackView, to: Int) {
        println(carTrackView.traces(to))
    }

    fun writeWinner(winners: List<Car>) {
        print("${winners.joinToString(", ") { it.name }}가 최종 우승했습니다.")
    }

    fun writeBlank() = println()
}
