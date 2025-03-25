package calculator

import calculator.exceptions.BlankInputException
import calculator.exceptions.EvenNumberElementsException
import calculator.exceptions.InvalidCharacterException
import calculator.exceptions.NotEnoughElementsException

object InputParser {
    fun validateInput(input: String?): List<String> {
        if (input.isNullOrBlank()) {
            throw BlankInputException()
        }
        validateCharacters(input)
        val inputList = input.split(Regex("\\s")).filterNot { it.isEmpty() }
        validateStructure(inputList)
        return inputList
    }

    private fun validateCharacters(input: String) {
        if (input.contains(Regex("[^0-9+\\-*/\\s]"))) {
            throw InvalidCharacterException()
        }
    }

    private fun validateStructure(inputList: List<String>) {
        if (inputList.size < MIN_ELEMENTS_AMOUNT) {
            throw NotEnoughElementsException()
        }
        if (inputList.size % 2 == 0) {
            throw EvenNumberElementsException()
        }
    }
}

private const val MIN_ELEMENTS_AMOUNT = 3
