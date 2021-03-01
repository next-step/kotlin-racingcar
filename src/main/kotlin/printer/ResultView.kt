package printer

import number.Numbers.START_INDEX
import java.util.stream.IntStream

object ResultView {
    fun printInt() {
        println("실행 결과")
    }

    fun printRacing(attempts: Int, carPositions: List<Int>) {
        repeat(attempts) {
            printCarsPath(carPositions)
            println()
        }
    }

    private fun printCarsPath(positions: List<Int>) {
        positions.forEach { position -> printCarPath(position) }
    }

    private fun printCarPath(position: Int) {
        IntStream.range(START_INDEX, position)
            .forEach {
                print("-")
            }

        println()
    }
}
