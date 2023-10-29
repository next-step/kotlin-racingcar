package racingcar

object ResultView {
    fun printResult() {
        println("실행 결과")
    }

    fun printSkid(distance: Int) {
        repeat(distance) {
            print("-")
        }
        println()
    }
}
