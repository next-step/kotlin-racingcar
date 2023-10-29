package racingcar.view

fun String.validateInputNumber(): String {
    return this
        .validateBlank()
        .validateNumber()
}

fun String.validateBlank(): String {
    require(isNotBlank()) { "입력값이 없습니다." }
    return this
}

fun String.validateNumber(): String {
    require(all { it.isDigit() }) { "숫자가 아닙니다." }
    return this
}
