package racingcar.view

class InputView {
    companion object {
        fun displayInput(message: String): Int {
            println(message)
            return getNumberInput()
        }

        private fun getNumberInput(): Int {
            val input = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
            require(input > 0) { "입력값은 1 이상이여야 합니다." }
            return input
        }
    }
}
