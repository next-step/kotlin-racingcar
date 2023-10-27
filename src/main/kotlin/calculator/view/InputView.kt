package calculator.view

object InputView {
    fun input(readlnOrNull: () -> String?): String {
        println("수식을 입력해주세요.")
        val inputFormula = readlnOrNull().let {
            if (it.isNullOrBlank()) {
                throw IllegalArgumentException("수식이 입력되지 않았습니다.")
            }
            it
        }
        return inputFormula
    }
}
