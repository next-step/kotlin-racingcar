package calculator

typealias FormulaConverterValidator = FormulaConverter.Validator

class FormulaConverter {
    fun convert(formula: String): FormulaElements {
        formula.shouldValidateFormula()

        val formulas = formula.split(Validator.formulaDelimiter).iterator()
        return FormulaElements(
            formulas.next().toDouble(),
            formulas.asSequence().toList().chunked(2).map {
                FormulaElement(
                    type = Operation.of(it[0])!!,
                    value = it[1].toDouble()
                )
            }
        )
    }

    private fun String.shouldValidateFormula() = Validator.checkValidateFormulaOrThrows(this)

    object Validator {
        const val formulaDelimiter = " "

        fun checkValidateFormulaOrThrows(formula: String) {
            formula.shouldNotEmpty()
            formula.shouldContainNumber()
            formula.numbersShouldValidPositions()
            formula.operationsShouldValidPositions()
            formula.shouldOddNumberDivided()
        }

        private fun String.shouldNotEmpty() = require(isNotEmpty())

        private fun String.shouldContainNumber() = require(split().any { it.toDoubleOrNull() != null })

        private fun String.numbersShouldValidPositions() = split().filterIndexed { index, _ -> index.isEven() }
            .forEach { require(it.toDoubleOrNull() != null) }

        private fun String.operationsShouldValidPositions() = split().filterIndexed { index, _ -> !index.isEven() }
            .forEach { require(Operation.of(it) != null) }

        private fun String.shouldOddNumberDivided() = require((split().size % 2) == 1)

        private fun String.split() = split(formulaDelimiter)

        private fun Int.isEven() = (this % 2) == 0
    }
}

enum class Operation(val op: String) {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDER("/");

    companion object {
        fun of(operation: String) = values().firstOrNull { it.op == operation }
    }
}
