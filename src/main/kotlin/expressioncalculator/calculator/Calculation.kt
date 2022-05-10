package expressioncalculator.calculator

data class Calculation(
    private val operator: Operator,
    private val number: Double
) {
    /**
     * 권장 : 이 함수 대신 아래의 compensates를 사용.
     *
     * <Calculation applyTo 숫자>와 같이 오른쪽에 왼쪽을 적용시키는 것 보다
     * <숫자 compensates Calculation>와 같이 왼쪽에 오른쪽을 적용시키는 게 논리적으로 이해하기 쉽다고 판단됨.
     */
    internal fun applyTo(accumulator: Double) = operator.operate(accumulator, number)
}

infix fun Double.compensates(calculation: Calculation): Double {
    return calculation.applyTo(this)
}
