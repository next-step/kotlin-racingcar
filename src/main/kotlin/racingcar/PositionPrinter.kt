package racingcar

import java.io.OutputStream
import java.io.PrintWriter

class PositionPrinter(private val positions: List<Positions>, outputStream: OutputStream) {
    private val printWriter: PrintWriter = PrintWriter(outputStream, true)

    constructor(positions: List<Positions>) : this(positions, System.out)

    fun print() {
        for (positions in positions) {
            positions.map { "-".repeat(it.intValue()) }
                .forEach(printWriter::println)

            printWriter.println()
        }
    }
}
