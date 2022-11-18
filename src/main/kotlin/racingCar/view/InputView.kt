package racingCar.view

object InputView {


    private const val CAR_NAME_SPLITTER = ","
    fun number(): Int {
        try {
            return validateInput().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다.", e)
        }
    }
    fun usernames(): List<String> = validateInput().split(CAR_NAME_SPLITTER)

    private fun validateInput(): String {
        val input = readLine()
        require(!input.isNullOrEmpty()) { "입력값은 비어있을 수 없습니다." }
        return input
    }
}
