package stringcalculator.extractor

import stringcalculator.Number

object OperandListExtractor : Extractor<ArrayDeque<Number>> {
    private val isEven: (Int) -> Boolean = { it % 2 == 0 }

    override fun extract(items: List<String>): ArrayDeque<Number> {

        return ArrayDeque(
            items.indices
                .filter(isEven)
                .map { Number(items[it]) }
        )
    }
}
