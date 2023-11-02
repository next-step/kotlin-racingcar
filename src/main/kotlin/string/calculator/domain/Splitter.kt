package string.calculator.domain

import string.calculator.util.isEven
import string.calculator.util.isOdd

class Splitter {
    fun split(input: String): Pair<MutableList<Long>, MutableList<Operator>> {
        val splitInput = input.split(DELIMITER)
        val numbers = splitInput.filterIndexed { index, _ -> index.isEven() }
            .map { it.toLong() }.toMutableList()
        val operators = splitInput.filterIndexed { index, _ -> index.isOdd() }
            .map { Operator.of(it) }.toMutableList()

        return numbers to operators
    }

    companion object {
        private const val DELIMITER = " "
    }
}
