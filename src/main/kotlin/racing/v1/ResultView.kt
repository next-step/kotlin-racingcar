package racing.v1

object ResultView {
    fun printPosition(position: Int) {
        repeat(position) {
            print('-')
        }
        println()
    }
}

