package study.step3

object ResultView {

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
