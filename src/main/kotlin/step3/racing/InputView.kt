package step3.racing

object InputView {
  fun getLong(input: Any?): Long = input.toString().toLongOrThrow()

  private fun String.toLongOrThrow(): Long =
    toLongOrNull() ?: throw IllegalArgumentException("유효하지 않은 입력 값입니다.")
}
