package racingcar

object ResultView {
    fun view(result: MutableList<List<Int>>) {
        for (i in 0..result[0].size - 1) {
            for (j in 0..result.size - 1) {
                printResult(result[j][i])
            }
            println()
        }
    }

    private fun printResult(value: Int) {
        for (i in 1..value) {
            print("-")
        }
        println()
    }
}
