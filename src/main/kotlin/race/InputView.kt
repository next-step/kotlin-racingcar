package race

class InputView(
    private val message: String,
) {
    fun processInput(): String {
        println(message)
        return readlnOrNull() ?: throw IllegalArgumentException("입력이 없습니다.")
    }

    fun processInputToInto(): Int {
        return processInput().toIntOrNull() ?: throw IllegalArgumentException("정수를 입력해주세요.")
    }
}
