package carracing.view

object InputView {
    fun getInput(promptQuestion: String): Int {
        print(promptQuestion)
        return readln().toIntOrNull() ?: 0
    }
}
