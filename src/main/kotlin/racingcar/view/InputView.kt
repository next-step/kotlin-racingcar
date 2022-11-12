package racingcar.view

interface InputView {
    fun printQuestion(question: String) = println(question)

    fun printInput() = readln()
    fun showQuestionAndGetInput(question: String): String {
        printQuestion(question)
        return printInput()
    }
}
