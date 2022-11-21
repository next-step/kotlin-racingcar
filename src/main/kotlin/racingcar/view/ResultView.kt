package racingcar.view

class ResultView {
    companion object {
        fun printResult(name: String, position: Int) {
            println("$name : ${"-".repeat(position)}")
        }

        fun printResultTitle() {
            println("\n" + "실행 결과")
        }

        fun printWinners(winners: List<String>) {
            println("${winners.joinToString(", ")}가 최종 우승했습니다.")
        }
    }
}
