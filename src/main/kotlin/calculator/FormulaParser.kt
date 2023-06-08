package calculator

typealias FormulaParserValidator = FormulaParser.Validator

class FormulaParser {

    object Validator {
        private val formulaDelimiter = " "

        fun checkValidateFormulaOrThrows(formula: String) {
            formula.shouldNotEmpty()
            formula.shouldContainNumber()
            formula.numbersShouldValidPositions()
            formula.operationsShouldValidPositions()
            formula.shouldOddNumberDivided()
        }

        private fun String.shouldNotEmpty() = require(isNotEmpty())

        private fun String.shouldContainNumber() = require(split().any { it.toDoubleOrNull() != null})

        private fun String.numbersShouldValidPositions() = split().chunked(2) { require(it[0].toDoubleOrNull() != null)}

        private fun String.operationsShouldValidPositions() = split().chunked(2) { require(Operation.of(it[1]) != null)}

        private fun String.shouldOddNumberDivided() = require((split().size % 2) == 1)

        private fun String.split() = split(formulaDelimiter)
    }
}

enum class Operation(val op: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDER("/");

    companion object {
        fun of(operation: String) = values().firstOrNull { it.op == operation }
    }
}