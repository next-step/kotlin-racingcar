package com.nextstep.racingcar.view

import com.nextstep.racingcar.domain.Cars

object OutputView {
    fun showResult() {
        println("실행 결과")
    }

    fun showStatus(cars: Cars) {
        for (car in cars.cars) {
            print("${car.getName()} : ")
            println("-".repeat(car.position))
        }
        println()
    }

    fun showWinner(winners: Cars) {
        val winnerNames = winners.cars.map { it.getName() }

        println("${winnerNames.joinToString(", ")}가 최종 우승했습니다.")
    }
}
