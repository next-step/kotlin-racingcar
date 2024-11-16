package racingcar

class ResultView {
    fun printResultMessage() {
        println("실행 결과")
    }

    fun printCurrentSituation(
        carNames: List<String>,
        extractCarInfos: List<Int>,
    ) {
        for ((carName, carPosition) in carNames.zip(extractCarInfos)) {
            print("$carName : ")
            println("-".repeat(carPosition))
        }
        println()
    }

    fun printWinner(winner: List<String>) {
        println("${winner.joinToString(", ")}가 최종 우승했습니다.")
    }
}
