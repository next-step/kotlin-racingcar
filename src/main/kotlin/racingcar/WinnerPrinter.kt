package racingcar

import java.io.ByteArrayOutputStream
import java.io.PrintWriter

class WinnerPrinter(private val names: List<String>, outputStream: ByteArrayOutputStream) {
    fun print() {
        printWriter.println(
            "${names.joinToString(", ")}가 최종 우승했습니다."
        )
    }

    private val printWriter = PrintWriter(outputStream, true)
}
