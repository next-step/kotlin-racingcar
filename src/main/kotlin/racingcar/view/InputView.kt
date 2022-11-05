package racingcar.view

interface InputView {
    fun printQuestion(question: String) = println(question)
    fun printInput() = readln()
}
