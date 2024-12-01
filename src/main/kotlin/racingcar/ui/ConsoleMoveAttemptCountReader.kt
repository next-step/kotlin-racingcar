package racingcar.ui

import racingcar.application.MoveAttemptCountReader

object ConsoleMoveAttemptCountReader : MoveAttemptCountReader {
    override fun read(): Int {
        ConsoleMessagePrinter.printMoveAttemptCountQuestion()
        val readLine = ReaderUtils.readLine()
        return convertToInt(readLine)
    }

    private fun convertToInt(readLine: String): Int {
        return readLine.toIntOrNull()
            ?: throw IllegalArgumentException("숫자만 입력할 수 있습니다.")
    }
}
