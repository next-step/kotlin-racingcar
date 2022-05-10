import java.util.regex.Pattern
import kotlin.jvm.Throws

class Expression(inputStr: List<String>) {

    var operators = listOf<String>()
    var digits = listOf<String>()

    init {
        operators = inputStr.extracts(VALID_DIGIT_PATTERN, false)
        digits = inputStr.extracts(VALID_DIGIT_PATTERN, true)

        val blankCount = inputStr.filter { s -> s.isBlank() }.count()
        if (blankCount > 0 || operators.isEmpty() || digits.isEmpty() ||
            !operators.validate(VALID_OPERATION_PATTERN) || !digits.validate(VALID_DIGIT_PATTERN)
        ) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        private val DIGITS_REGEX = "^[0-9]*$"
        private val OPERATORS_REGEX = "[*+-/]"
        private val VALID_DIGIT_PATTERN: Pattern = Pattern.compile(DIGITS_REGEX)
        private val VALID_OPERATION_PATTERN: Pattern = Pattern.compile(OPERATORS_REGEX)
    }
}

fun List<String>.extracts(patterns: Pattern, match: Boolean): List<String> {
    return filter { patterns.matcher(it).find() == match }
}

@Throws(IllegalArgumentException::class)
fun List<String>.validate(patterns: Pattern): Boolean {
    val seq = this.asSequence()
    return seq.all {
        a ->
        patterns.matcher(a).find()
    }
}
