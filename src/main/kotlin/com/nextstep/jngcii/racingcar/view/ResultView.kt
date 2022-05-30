package com.nextstep.jngcii.racingcar.view

import com.nextstep.jngcii.racingcar.domain.History
import com.nextstep.jngcii.racingcar.domain.Record

object ResultView {
    private const val DASH = "-"
    private const val JOIN_SEPARATOR = ", "

    fun print(history: History) {
        println("실행 결과")

        history.records
            .forEach { printSingleRecord(it) }

        val winners = history.winners
            .joinToString(JOIN_SEPARATOR) { it.name }

        println("${winners}가 최종우승했습니다.")
    }

    private fun printSingleRecord(record: Record) {
        record.distanceByName
            .forEach { printSingleCarDistance(it) }
        println()
    }

    private fun printSingleCarDistance(car: Map.Entry<String, Int>) {
        val (name, distance) = car
        println("$name : ${DASH.repeat(distance)}")
    }
}
