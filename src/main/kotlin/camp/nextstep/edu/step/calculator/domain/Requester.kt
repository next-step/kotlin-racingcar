package camp.nextstep.edu.step.calculator.domain

data class Requester(
    val expression: String = ""
) {

    init {
        require(expression.isNotBlank()) { "수식이 비어있습니다." }
    }

    fun splitExpression(): List<String> {
        return expression.split(" ")
    }

}
