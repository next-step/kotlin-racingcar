package racingcar.view

import racingcar.domain.Positions
import java.io.OutputStream
import java.io.PrintWriter

class PositionPrinter(private val positions: List<Positions>, outputStream: OutputStream = System.out) {
    private val printWriter = PrintWriter(outputStream, true)

    fun print() {
        positions.forEach {
            it.map { positions -> PositionString(positions) }
                .forEach(printWriter::println)

            printWriter.println()
        }
    }
}
