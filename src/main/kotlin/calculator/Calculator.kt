package calculator

fun calculate(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("공백은 계산할 수 없다.")
    }
    val values = input.split(" ")
    validateCalculateFormat(values)
    return 0
}

private fun validateCalculateFormat(values: List<String>) {
    if (values.size % 2 == 0) {
        throw IllegalArgumentException("올바른 형태로 수식을 입력하여야 한다.")
    }
}
