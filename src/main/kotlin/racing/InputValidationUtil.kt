package racing

fun String.inputConverter(): Int {
    return this
        .validateForm()
        .validateRange()
}

private fun String.validateForm(): Int {
    return this.toIntOrNull() ?: throw IllegalArgumentException("올바른 입력값의 형식이 아닙니다")
}

private fun Int.validateRange(): Int {
    require(this > 0) { "입력값의 범위는 1 이상입니다" }
    return this
}