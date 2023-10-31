package racingcar

object ConsoleInputView : InputProvider {
    override fun getIntInput(prompt: String): Int {
        println(prompt)
        return readln().toInt()
    }
}
