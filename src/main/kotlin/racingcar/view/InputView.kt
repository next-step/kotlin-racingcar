package racingcar.view

class InputView {
    companion object {
        fun displayInput(message: String): Int {
            println(message)
            return getNumberInput()
        }

        fun carNamesInput(): List<String> {
            println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
            return readlnOrNull()?.split(",")?.map { it.trim() } ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
        }

        private fun getNumberInput(): Int {
            val input = readlnOrNull()?.toInt() ?: throw IllegalArgumentException("입력값이 잘못되었습니다.")
            require(input > 0) { "입력값은 1 이상이여야 합니다." }
            return input
        }
    }
}
