package racingcar

class ResultView {
    fun show(result: List<List<Int>>) {
        result.forEach { moves ->
            moves.forEach { move ->
                println("".padEnd(move, '-'))
            }
            print("\n")
        }
    }
}
