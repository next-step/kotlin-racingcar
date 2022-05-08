import java.util.regex.Pattern
import kotlin.jvm.Throws

class Expression(inputStr: List<String>) {

    open var operators = listOf<String>()
    open var digits = listOf<String>()

    init {
        operators = inputStr.extracts(validDigitPattern, false)
        digits = inputStr.extracts(validDigitPattern, true)

        val blankCount = inputStr.stream().filter { s -> s.isBlank() }.count().toInt()
        if (blankCount > 0 || operators.size == 0 || digits.size == 0 ||
            !operators.validate(validOperatorPattern) || !digits.validate(validDigitPattern)
        ) {
            throw IllegalArgumentException()
        }
    }

    companion object {
        var DIGITS_REGEX = "^[0-9]*$"
        var OPERATORS_REGEX = "[*+-/]"
        val validDigitPattern: Pattern = Pattern.compile(DIGITS_REGEX)
        val validOperatorPattern: Pattern = Pattern.compile(OPERATORS_REGEX)
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
