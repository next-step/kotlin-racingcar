package racingcar.ui

import racingcar.application.CarNameReader

object ConsoleCarNameReader : CarNameReader {
    override fun read(): List<String> {
        ConsoleMessagePrinter.printCarNameQuestion()
        val readLine = ReaderUtils.readLine()
        return readLine.split(",")
    }
}
