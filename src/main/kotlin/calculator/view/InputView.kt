package calculator.view

object InputView {

    fun input(readln: () -> String): String {
        println("수식을 입력해주세요.")
        val input = readln().let {
            validateInput(it)
            it
        }
        return input
    }

    private fun validateInput(it: String) {
        if (it.isBlank()) {
            throw IllegalArgumentException("수식이 입력되지 않았습니다.")
        }
    }
}
