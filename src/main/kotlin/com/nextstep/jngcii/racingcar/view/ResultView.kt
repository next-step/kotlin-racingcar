package com.nextstep.jngcii.racingcar.view

class ResultView {
    fun printInitialPhase() {
        println("실행 결과")
    }

    fun printDistance(name: String, distance: Int) {
        println("$name : ${DASH.repeat(distance)}")
    }

    fun printFinalPhase(winners: List<String>) {
        println("${winners.joinToString(JOIN_SEPARATOR)}가 최종우승했습니다.")
    }

    companion object {
        private const val EMPTY_STRING = ""
        private const val DASH = "-"
        private const val JOIN_SEPARATOR = ", "
    }
}
