package racingcar.view

import racingcar.domain.Car
import racingcar.domain.RaceResult

object ResultView {
    fun show(listCar: List<Car>) {
        printCurrentPosition(listCar)
    }

    fun showResultTitle() {
        println("\n[실행 결과]")
    }

    fun showResult(raceResult: RaceResult) {
        println("\n[실행 결과]")
        // todo 매 경기 자동차 위치 출력
    }

    private fun printCurrentPosition(listCar: List<Car>) {
        listCar.map { car ->
            (0 until car.position).map { print("-") }
            println("")
        }
        println("")
    }
}
