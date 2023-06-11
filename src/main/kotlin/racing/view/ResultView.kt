package racing.view

object ResultView {

    fun printResult() {
        println("실행 결과")
    }

    fun printDistance(position: Int) {
        val distance = "-".repeat(position)
        println(distance)
    }

    fun printEnter() {
        println()
    }
}
