package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Cars

object OutputView {
    fun showResult() {
        println("실행 결과")
    }

    fun showStatus(cars: Cars) {
        for (car in cars.cars) {
            println("-".repeat(car.position))
        }
        println()
    }
}
