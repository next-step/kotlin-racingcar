package racingcar

import java.io.OutputStream
import java.io.PrintWriter

class PositionPrinter(private val positions: List<Positions>, outputStream: OutputStream = System.out) {
    private val printWriter = PrintWriter(outputStream, true)

    fun print() {
        for (positions in positions) {
            positions.map { "-".repeat(it.intValue()) }
                .forEach(printWriter::println)

            printWriter.println()
        }
    }
}
