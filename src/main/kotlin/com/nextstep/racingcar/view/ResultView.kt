package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Movement

class ResultView {

    fun printResult() = println("실행 결과")

    fun printResult(movement: Movement) = println(convertToView(movement))

    private fun convertToView(movement: Movement): String = if (movement == Movement.MOVE) "-" else ""

    fun printLine() = println()
}
