package calculator.ui

const val DIVIDER_CHARACTER = "="
const val DIVIDER_REPEAT_COUNT = 20

interface OutputView {
    fun sayHowToUse()
    fun sayAnswer(answer: Double)

    fun withDivider(method: () -> Unit) {
        val divider = DIVIDER_CHARACTER.repeat(DIVIDER_REPEAT_COUNT)
        println(divider)
        method()
        println(divider + System.lineSeparator())
    }
}
