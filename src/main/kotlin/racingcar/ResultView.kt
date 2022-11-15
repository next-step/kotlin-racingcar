package racingcar

class ResultView {

    fun show(result: Map<Int, String>) {
        println("")
        println("실행 결과")
        result.forEach {
            println(it.value)
            println("")
        }
    }
}
