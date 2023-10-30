package racing

class ResultView {
    companion object {
        fun printPosition(position: Int) {
            repeat(position) {
                print('-')
            }
            println()
        }
    }
}
