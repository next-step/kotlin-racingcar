package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Cars
import com.nextstep.racingcar.domain.Movement

class CliResultView : ResultView {

    override fun printBeforeResult() = println("실행 결과")

    override fun printBeforeResult(cars: Cars) {
        val resultView = StringBuilder()
        cars.getHistories().forEach {
            resultView.append(it.first)
            resultView.append(" : ")
            resultView.append(convertToView(it.second))
            resultView.appendLine()
        }
        println(resultView.toString())
    }

    private fun convertToView(movements: List<Movement>): String = movements.joinToString(separator = "") { convertToView(it) }

    private fun convertToView(movement: Movement): String = if (movement == Movement.MOVE) "-" else ""
}
