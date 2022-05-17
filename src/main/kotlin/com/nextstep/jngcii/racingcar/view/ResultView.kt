package com.nextstep.jngcii.racingcar.view

import com.nextstep.jngcii.racingcar.domain.Record

class ResultView {

    fun printInitialPhase() {
        println("실행 결과")
    }

    fun printResult(record: Record) {
        for (carIndex in 0 until record.carCount) {
            record.getGoCount(carIndex).printGoCount()
        }
        println()
    }

    private fun Int.printGoCount() {
        var result = "(${this}칸) "
        repeat(this) {
            result += "-"
        }
        println(result)
    }
}
