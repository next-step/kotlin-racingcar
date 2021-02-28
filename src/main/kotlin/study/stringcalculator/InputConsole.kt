package study.stringcalculator

class InputConsole {

    fun readExpression(): List<String> {
        return splitExpression(readLine())
    }

    fun splitExpression(expression: String?): List<String> {
        if (expression.isNullOrBlank()) throw IllegalArgumentException("IllegalArgumentException")
        return expression.split(" ")
    }
}
