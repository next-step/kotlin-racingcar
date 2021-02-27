package study.step3

class ResultView {

    fun outputResultString() {
        println("실행 결과")
    }

    fun outputResult(result: List<Car>) {
        result.forEach {
            println(it.distance)
        }
        println()
    }
}
