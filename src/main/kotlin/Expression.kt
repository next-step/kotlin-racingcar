import java.util.regex.Pattern
import kotlin.jvm.Throws

class Expression(inputStr: List<String>) {

    var operators = listOf<String>()
    var digits = listOf<String>()

    init {
        operators = inputStr.extracts(VALID_DIGIT_PATTERN, false)
        digits = inputStr.extracts(VALID_DIGIT_PATTERN, true)

        val blankCount = inputStr.stream().filter { s -> s.isBlank() }.count().toInt()
        if (blankCount > 0 || operators.size == 0 || digits.size == 0 ||
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
    val list = mutableListOf<String>()
    this.stream().forEach { a ->
        if (patterns.matcher(a).find() == match) {
            list.add(a)
        }
    }

    return list
}

@Throws(IllegalArgumentException::class)
fun List<String>.validate(patterns: Pattern): Boolean {
    return this.stream().allMatch { a -> patterns.matcher(a).find() }
}
