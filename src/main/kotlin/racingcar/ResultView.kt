package racingcar

class ResultView {
    fun printCarPosition(position: Int) {
        for (i in 0 until position) {
            print('-')
        }
        println()
    }
}