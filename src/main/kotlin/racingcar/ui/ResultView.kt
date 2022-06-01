package racingcar.ui

import racingcar.domain.RacingGame

class ResultView {

    fun printRaceProgress(racingGame: RacingGame, numberOfAttempts: Int) {
        println("실행 결과")
        repeat(numberOfAttempts) {
            println("${it + 1} 회차")
            racingGame.move()
            racingGame.movements.forEach { println("-".repeat(it)) }
        }
    }
}
