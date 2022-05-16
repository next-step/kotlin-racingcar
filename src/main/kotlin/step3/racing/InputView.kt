package step3.racing

object InputView {
  fun getLong(input: String?): Long {
    input ?: throw IllegalArgumentException("입력 값이 없습니다.")
    return input.toLong()
  }
}
