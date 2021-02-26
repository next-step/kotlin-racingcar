package step2.ui

fun inputExpression(): String {
    print("수식 입력: ")
    return (readLine() ?: throw IllegalArgumentException("null 을 입력할 수 없습니다."))
        .checkBlank()
}

fun String.checkBlank() = apply {
    if (isBlank()) {
        throw IllegalArgumentException("공백을 입력할 수 없습니다.")
    }
}
