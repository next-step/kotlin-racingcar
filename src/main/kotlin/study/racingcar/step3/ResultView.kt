package study.racingcar.step3

class ResultView(private val results: List<Result>) {

    fun render() {
        println()
        for (result in results) println(result.render())
    }
}
