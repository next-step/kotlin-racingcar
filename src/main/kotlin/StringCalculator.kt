import java.beans.Expression

class StringCalculator {

    fun calculate(expression: List<String>): Double {
        var result = expression.first().toDouble()

        for (operatorIndex in 1 until expression.size step 2) {
            val operator = Operator.fromSymbol(expression[operatorIndex])
            val nextNumber = expression[operatorIndex + 1].toDouble()
            result = operator.apply(result, nextNumber)
        }
        return result
    }

}
