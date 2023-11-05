package racingcar.ui

class ResultView {

    fun printRacingGameHistory(history: List<List<Int>>) {
        buildString {
            appendLine("실행 결과")
            history.forEach { positions ->
                positions.forEach { position ->
                    repeat(position) {
                        append('-')
                    }
                    appendLine()
                }
                appendLine()
            }
        }.also {
            println(it)
        }
    }
}
