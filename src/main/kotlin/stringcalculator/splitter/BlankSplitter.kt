package stringcalculator.splitter

object BlankSplitter : Splitter<String> {
    private const val DELIMITER = " "

    override fun split(input: String?): List<String> = input?.run {
        split(DELIMITER).filter { it.isNotBlank() }
    } ?: throw IllegalArgumentException("Invalid Value")
}
