package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Car
import com.nextstep.racingcar.domain.Movement

class ResultView {

    fun printResult() = println("실행 결과")

    fun printResult(car: Car) {
        val resultView = StringBuilder()
        for (movement in car.getHistories()) {
            resultView.append(convertToView(movement))
        }
        println(resultView.toString())
    }

    private fun convertToView(movement: Movement): String = if (movement == Movement.MOVE) "-" else ""

    fun printLine() = println()
}
