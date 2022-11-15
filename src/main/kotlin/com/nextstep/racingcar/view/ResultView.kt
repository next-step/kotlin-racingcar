package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Car

interface ResultView {
    fun printResult(): Unit
    fun printResult(car: Car): Unit
    fun printLine(): Unit
}
