package calculator

enum class Operator (val operator: String, val expression: (Int, Int) -> Int){
    PLUS("+", {result, additionalNumber -> result + additionalNumber}),
    MINUS("-", {result, additionalNumber -> result - additionalNumber}),
    MULTIPLY("*", {result, additionalNumber -> result * additionalNumber}),
    DIVIDE("/", {result, additionalNumber -> if(additionalNumber == 0) throw IllegalArgumentException("숫자를 0으로 나눌 순 없습니다.") else result / additionalNumber });

    companion object {
        fun makeOperator(operator: String) : Operator {
            return Operator.values().find { it.operator == operator } ?: throw IllegalArgumentException("사용 불가능한 연산자입니다.")
        }
    }
}
