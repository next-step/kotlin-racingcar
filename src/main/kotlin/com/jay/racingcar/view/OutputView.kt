package com.jay.racingcar.view

import com.jay.racingcar.domain.RacingCars

class OutputView {
    companion object {
        private const val DISTANCE_MARK = "-"

        fun printOutputMessage() {
            println("실행 결과")
        }

        fun printResult(racingCars: RacingCars) {
            racingCars.racingCars
                .forEach {
                    println(DISTANCE_MARK.repeat(it.position))
                }
            println()
        }
    }
}
