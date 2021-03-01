package study.racingcar.step3

class ResultView(private val results: List<Result>) {

    fun show() {
        for (result in results) println(result.show())
        println()
    }
}
