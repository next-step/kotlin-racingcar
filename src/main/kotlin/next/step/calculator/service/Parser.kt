package next.step.calculator.service

object Parser {
    private const val SPACE: String = " "
    fun parse(s: String): List<String> {
        return s.split(SPACE)
    }
}
