package stringcalculator.operator

class OperatorSelector(
    operators: List<Operator>
) {
    private val operatorMap: Map<String, Operator> = operators.associateBy { it.character() }

    fun get(operator: String): Operator {
        if (!operatorMap.containsKey(operator)) {
            throw IllegalArgumentException("연산자 자리에 다른 문자가 입력되었습니다.")
        }
        return operatorMap[operator]!!
    }
}
