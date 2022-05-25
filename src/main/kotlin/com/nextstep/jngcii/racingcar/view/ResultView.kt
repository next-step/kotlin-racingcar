package com.nextstep.jngcii.racingcar.view

import com.nextstep.jngcii.racingcar.domain.History
import com.nextstep.jngcii.racingcar.domain.Record

class ResultView {
    fun print(history: History) {
        println("실행 결과")

        history.records.forEach {
            printSingleRecord(it)
        }

        println("${history.cars.winners.joinToString(JOIN_SEPARATOR)}가 최종우승했습니다.")
    }

    private fun printSingleRecord(record: Record) {
        record.distanceByName.forEach { (name, distance) ->
            println("$name : ${DASH.repeat(distance)}")
        }
        println()
    }

    companion object {
        private const val DASH = "-"
        private const val JOIN_SEPARATOR = ", "
    }
}
