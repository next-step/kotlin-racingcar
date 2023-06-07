package stringcalculator.extractor

import stringcalculator.Operator

object OperatorListExtractor : Extractor<ArrayDeque<Operator>> {
    private val isOdd: (Int) -> Boolean = { it % 2 == 1 }

    override fun extract(items: List<String>): ArrayDeque<Operator> {

        return ArrayDeque(
            items.indices
                .filter(isOdd)
                .map { Operator.findBySymbol(items[it]) }
        )
    }
}
