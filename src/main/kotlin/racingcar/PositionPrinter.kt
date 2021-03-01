package racingcar

import java.io.OutputStream
import java.io.PrintWriter

class PositionPrinter(private val positions: List<Positions>, outputStream: OutputStream = System.out) {
    private val printWriter = PrintWriter(outputStream, true)

    fun print() {
        positions.forEach {
            it.map { position -> "-".repeat(position.intValue()) }
                .forEach(printWriter::println)

            printWriter.println()
        }
    }
}
