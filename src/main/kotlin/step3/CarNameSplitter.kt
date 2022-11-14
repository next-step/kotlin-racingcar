package step3

object CarNameSplitter {
    private const val COMMA = ","

    fun execute(target: String): List<String> {
        return target
            .split(COMMA)
            .map { it.trim() }
    }
}
