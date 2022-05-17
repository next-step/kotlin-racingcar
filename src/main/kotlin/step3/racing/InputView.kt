package step3.racing

object InputView {
  fun getInt(input: String?): Int {
    require(!input.isNullOrBlank()) { "입력 값이 없습니다." }
    return input.toIntOrThrow()
  }

  fun getStringArray(input: String?): List<String> {
    require(!input.isNullOrBlank()) { "입력 값이 없습니다." }
    return input.split(",")
  }

  private fun String.toIntOrThrow(): Int =
    toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되지 않았습니다.")
}
