package racingcar

class ResultView {
    fun printResult(result: String) {
        if (result.last() == ',') {
            print(result.substring(0, result.lastIndex))
        }
        if (result.last() != ',') {
            print(result)
        }
        println("가 최종 우승했습니다.")
    }
}
