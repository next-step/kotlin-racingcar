package com.nextstep.jngcii.racingcar.view

import com.nextstep.jngcii.racingcar.domain.Record

class ResultView {

    fun printResult(record: Record) {
        println("실행 결과")

        for (carIndex in 0 until record.carCount) {
            record.getGoCount(carIndex).printGoCount()
        }
    }

    private fun Int.printGoCount() {
        var result = "(${this}칸) "
        repeat(this) {
            result += "-"
        }
        println(result)
    }
}
