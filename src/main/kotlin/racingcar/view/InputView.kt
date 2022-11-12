package racingcar.view

class InputView {

    fun getCarNameByInput(question: String) = showQuestionAndGetInput(question).split(",")

    fun getCarCountByInput(question: String) = showQuestionAndGetInput(question).toInt()

    fun getRaceRoundByInput(question: String) = showQuestionAndGetInput(question).toInt()

    private fun printQuestion(question: String) = println(question)

    private fun printInput() = readln()
    private fun showQuestionAndGetInput(question: String): String {
        printQuestion(question)
        return printInput()
    }
}
