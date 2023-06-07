package stringcalculator.extractor

import stringcalculator.Operator
import java.util.LinkedList
import java.util.Queue

object OperatorListExtractor : Extractor<Queue<Operator>> {
    private val isOdd: (Int) -> Boolean = { it % 2 == 1 }

    override fun extract(items: List<String>): Queue<Operator> {
        return LinkedList(
            items.indices
                .filter(isOdd)
                .map { Operator.findBySymbol(items[it]) }
        )
    }
}
