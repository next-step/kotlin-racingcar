package step2

fun requireNotZero(number: Int) = require(number != 0)

fun checkNotBlank(text: String?): String {
    requireNotNull(text)
    require(text.isNotBlank())

    return text
}
