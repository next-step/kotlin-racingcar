package calculate

class OperatorValidation : CalculateValidation {
    override fun validate(input: String) {
        val target = input.split("\\d+".toRegex()).filter { it.isNotBlank() }
        for (operator in target) {
            if (operator.length > 1) {
                throw IllegalArgumentException("연산자는 한번에 1개만 가능합니다")
            }
            if (!operator.matches("[+\\-*/]".toRegex())) {
                throw IllegalArgumentException("지원하지 않는 연산자입니다.")
            }
        }
    }
}
