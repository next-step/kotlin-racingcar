package racingcars.util

private const val MINIMUM_INPUT_NUMBER = 1

fun String?.validInputToInt(): Int {
    return this?.toIntOrNull()
        ?.takeIf { it >= MINIMUM_INPUT_NUMBER }
        ?: throw IllegalArgumentException("유효한 값을 입력해주세요")
}
