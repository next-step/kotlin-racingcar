package calculator

object SplitUtil {

    fun splitExpression(expression: Expression): List<String> {
        return expression.inputs.split(" ")
    }

}