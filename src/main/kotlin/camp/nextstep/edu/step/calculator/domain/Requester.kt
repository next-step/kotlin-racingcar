package camp.nextstep.edu.step.calculator.domain

data class Requester(
    val expression: String = ""
) {

    fun validate() {
        if (expression.isBlank()) {
            throw IllegalArgumentException("수식이 비어있습니다.")
        }
    }

    fun splitExpression(): List<String> {
        return expression.split(" ")
    }
}
