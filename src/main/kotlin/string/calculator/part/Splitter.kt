package string.calculator.part

import string.calculator.dto.SplitInput
import string.calculator.domain.Operator
import string.calculator.util.isEven
import string.calculator.util.isOdd

class Splitter {
    fun split(input: String): SplitInput {
        val numbers = mutableListOf<Long>()
        val operators = mutableListOf<Operator>()
        val splitInput = input.split(DELIMITER)

        for (i in splitInput.indices) {
            if (i.isEven()) {
                numbers.add(splitInput[i].toLong())
            }
            if (i.isOdd()) {
                operators.add(Operator.of(splitInput[i]))
            }
        }

        return SplitInput(numbers, operators)
    }

    companion object {
        const val DELIMITER = " "
    }
}
