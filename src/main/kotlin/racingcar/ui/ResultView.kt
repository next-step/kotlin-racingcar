package racingcar.ui

class ResultView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printRacingRound(round: Int) {
        println("${round + 1} 회차")
    }

    fun printRacingCarMovement(movement: Int) {
        println("-".repeat(movement))
    }
}
