package step2.tasks

import step2.data.Operand
import step2.data.Operator
import step2.util.extension.toDouble
import step2.util.Const.Companion.DELIMITERS_BLANK
import step2.util.Const.Companion.NOTICE_NOT_OPERAND_SYMBOL
import step2.util.extension.splitToCalculate

class Calculator {
    fun splitReadLine(): List<String> {
        return readLine().splitToCalculate(DELIMITERS_BLANK)
    }

    fun calculate(anyOfCollection: List<String>): String {
        return anyOfCollection.reduceIndexed { index, acc, element ->
            if (index % 2 != 1 && index > 0) {
                val operator =
                    Operator.findByOperatorSymbol(anyOfCollection[index - 1])
                return@reduceIndexed operator.calculate(
                    Operand(acc.toDouble(NOTICE_NOT_OPERAND_SYMBOL)),
                    Operand(element.toDouble(NOTICE_NOT_OPERAND_SYMBOL))
                ).toString()
            }
            return@reduceIndexed acc
        }
    }
}
