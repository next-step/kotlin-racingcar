package racingcar.ui

import racingcar.domain.RacingCarGame

object ResultView {
    fun printResult(racingCarGame: RacingCarGame) {
        for (racer in racingCarGame.racers) {
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
