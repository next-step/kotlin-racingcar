package racing.view

class OutputView {

    fun renderStartMessage() {
        print("실행 결과")
    }

    fun renderPositions(positions: List<Int>) {
        println()
        positions.forEach {
            val builder = StringBuilder()
            for (i in 0 until it) {
                builder.append('-')
            }
            println(builder.toString())
        }
    }
}
