package racingcar.ui

import racingcar.domain.Racer

class ResultView {
    companion object {
        fun printResult(racers: MutableList<Racer>) {
            for (racer in racers) {
                for (j in 1..racer.count)
                    print("-")
                println()
            }
            println()
        }
        fun printInitMessage() {
            println()
            println("실행 결과")
        }
    }
}
