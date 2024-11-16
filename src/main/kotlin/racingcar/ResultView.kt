package racingcar

class ResultView {
    fun printResultMessage() {
        println("실행 결과")
    }

    fun printCurrentSituation(
        carNames: List<String>,
        extractCarInfos: List<Int>,
    ) {
        for (carPosition in extractCarInfos) {
            print(carNames[extractCarInfos.indexOf(carPosition)] + " : ")
            println("-".repeat(carPosition))
        }
        println()
    }
}
