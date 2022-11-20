package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Cars

interface ResultView {
    fun printBeforeResult(): Unit
    fun printBeforeResult(car: Cars): Unit
}
