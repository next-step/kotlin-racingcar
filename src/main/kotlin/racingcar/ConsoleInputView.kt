package racingcar

object ConsoleInputView : InputProvider {
    override fun getIntInput(prompt: String): Int {
        println(prompt)
        return readln().toInt()
    }

    override fun getStringInput(prompt: String): List<String> {
        println(prompt)
        return readln().split(",")
    }
}
