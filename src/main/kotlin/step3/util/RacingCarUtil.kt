package step3.util

fun String?.validInputToInt(): Int {
    return this?.toIntOrNull()
        ?.takeIf { it >= 1 }
        ?: throw IllegalArgumentException("유효한 값을 입력해주세요")
}
