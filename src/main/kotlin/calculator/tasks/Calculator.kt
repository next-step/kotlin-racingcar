package calculator.tasks

import calculator.data.Operand
import calculator.data.Operator
import calculator.util.extension.toDouble
import calculator.util.Message.Companion.NOTICE_NOT_OPERAND_SYMBOL

class Calculator {

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
