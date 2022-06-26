package racingcar.ui

class ResultView {

    fun printResultTitle() {
        println("\n실행 결과")
    }

    fun printRacingRound(round: Int) {
        println("\n${round + 1} 회차")
    }

    fun printRacingCarMovements(names: List<String>, movements: List<Int>) {
        names.forEachIndexed { index, name -> println("$name : ${"-".repeat(movements[index])}") }
    }

    fun printRacingWinners(winners: List<String>) {
        println("\n${winners.joinToString(", ")}이(가) 최종 우승했습니다.")
    }
}
