package com.jay.racingcar.view

import com.jay.racingcar.domain.RacingCars

class OutputView {
    companion object {
        private const val DISTANCE_MARK = "-"

        fun printCarInputMessage() {
            println("자동차 대수는 몇 대인가요?")
        }

        fun printTryMessage() {
            println("시도할 횟수는 몇 회인가요?")
        }

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
