package calculator

data class FormulaElement(
    val value: String,
    val type: FormulaType
)


enum class FormulaType {
    VALUE, OPERATION
}