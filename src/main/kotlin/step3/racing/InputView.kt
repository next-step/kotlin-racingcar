package step3.racing

object InputView {
    fun getLong(input: String?): Long {
        input ?: throw IllegalArgumentException("입력 값이 없습니다.")
        return input.toLongOrThrow()
    }

    private fun String.toLongOrThrow(): Long =
        toLongOrNull() ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
}
