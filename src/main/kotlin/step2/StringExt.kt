package step2

fun String.toLongOnlyNumber(): Long {
    return this.toLongOrNull() ?: throw IllegalArgumentException("숫자만 허용됩니다.")
}
