package step2

import step2.inspector.mustNot

fun main() {
    val expression = readlnOrNull()
    mustNot {
        expression.isNullOrBlank()
    }
}