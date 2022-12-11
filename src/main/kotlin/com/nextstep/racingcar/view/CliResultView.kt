package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Car
import com.nextstep.racingcar.domain.Cars
import com.nextstep.racingcar.domain.Movement

class CliResultView : ResultView {

    override fun printBeforeResult() = println("실행 결과")

    override fun printBeforeResult(cars: Cars) {
        val resultView = StringBuilder()
        cars.cars.forEach {
            resultView.append(it.name)
            resultView.append(" : ")
            resultView.append(convertToView(it.getHistories()))
            resultView.appendLine()
        }
        println(resultView.toString())
    }

    override fun printWinners(findWinners: List<Car>) {
        println(findWinners.joinToString(separator = ",") { it.name } + "가 최종 우승했습니다.")
    }

    private fun convertToView(movements: List<Movement>): String = movements.joinToString(separator = "") { convertToView(it) }

    private fun convertToView(movement: Movement): String = if (movement == Movement.MOVE) "-" else ""
}
