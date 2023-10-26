package string.calculator.part

import string.calculator.dto.SplitInput
import string.calculator.enum.Operator

class Splitter {
    fun split(input: String): SplitInput {
        val numbers = mutableListOf<Long>()
        val operators = mutableListOf<Operator>()
        val splitInput = input.split(DELIMITER)

        for (i in splitInput.indices) {
            if (i % 2 == 0) {
                numbers.add(splitInput[i].toLong())
            } else {
                operators.add(Operator.of(splitInput[i]))
            }
        }

        return SplitInput(numbers, operators)
    }

    companion object {
        const val DELIMITER = " "
    }
}
