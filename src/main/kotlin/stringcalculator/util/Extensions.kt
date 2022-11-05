package step2.operator

fun String.removeRepeatedBlank(): String {
    return trim().replace(Regex(" +"), " ")
}
