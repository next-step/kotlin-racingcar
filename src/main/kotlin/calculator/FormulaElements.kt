package calculator

class FormulaElements(
    val startValue: Double,
    elements: List<FormulaElement>
) {
    private val elementsIterator = elements.iterator()

    fun nextFormulaElement(): FormulaElement? = if(elementsIterator.hasNext()) elementsIterator.next() else null
}

data class FormulaElement(
    val value: Double,
    val type: Operation
)