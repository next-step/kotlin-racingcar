package calculator

fun calculate(input: String): Int {
    if (input.isBlank()) {
        throw IllegalArgumentException("공백은 계산할 수 없다.")
    }
    return 0
}
