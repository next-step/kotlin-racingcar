package calculator

object SplitUtil {

    fun splitExpression(expression: Expression): List<String> {
        return expression.toString().split(" ")
    }

}