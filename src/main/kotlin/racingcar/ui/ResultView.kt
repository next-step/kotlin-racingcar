package racingcar.ui

class ResultView {

    fun printCarPositions(carPositions: List<Int>) {
        buildString {
            repeat(carPositions.size) { carIdx ->
                append("Car${carIdx}: ")
                repeat(carPositions[carIdx]) {
                    append('-')
                }
                appendLine()
            }
        }.also {
            println(it)
        }
    }
}
