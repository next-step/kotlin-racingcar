package calculator.ui

import calculator.util.Message
import calculator.util.extension.splitToCalculate

fun splitReadLine(): List<String> {
    println(Message.NOTICE_INPUT)
    return readLine().splitToCalculate(Message.DELIMITERS_BLANK)
}
