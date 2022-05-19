package com.nextstep.jngcii.racingcar.view

class ResultView {
    fun printInitialPhase() {
        println("실행 결과")
    }

    fun printDistance(distance: Int) {
        println(distance.shape)
    }

    private val Int.shape get() = List(this) { DASH }.joinToString(EMPTY_STRING)

    companion object {
        private const val EMPTY_STRING = ""
        private const val DASH = "-"
    }
}
