package carracing.view

object InputView {
    fun getCarNames(promptQuestion: String): List<String> {
        print(promptQuestion)
        return readlnOrNull()?.split(",")?.map { it.trim() }?.filter { it.isNotEmpty() }
            ?: emptyList()
    }

    fun getRoundInput(promptQuestion: String): Int {
        print(promptQuestion)
        return readln().toIntOrNull() ?: 0
    }
}
