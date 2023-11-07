package racingcar.view

import racingcar.adapter.CarDto

interface ResultView {
    fun printResultStart()

    fun printResult(cars: List<CarDto>)

    fun printWinners(winners: List<String>)
}
