package stringcalculator.extractor

import java.util.LinkedList
import java.util.Queue
import stringcalculator.Number as Number

object OperandListExtractor : Extractor<Queue<Number>> {
    private val isEven: (Int) -> Boolean = { it % 2 == 0 }

    override fun extract(items: List<String>): Queue<Number> {
        return LinkedList(
            items.indices
                .filter(isEven)
                .map { Number(items[it]) }
        )
    }
}
