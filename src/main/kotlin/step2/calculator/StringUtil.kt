package step2.calculator

fun String.toLongOrThrow(): Long =
    toLongOrNull() ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
