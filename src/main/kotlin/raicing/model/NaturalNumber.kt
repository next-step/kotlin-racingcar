package raicing.model

import raicing.Const

@JvmInline
value class NaturalNumber(
    private val number: String
) {

    init {
        validateNaturalNumber(validateInt(number))
    }

    fun toInt() = number.toInt()

    private fun validateInt(number: String): Int =
        requireNotNull(number.toIntOrNull()) { Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG }

    private fun validateNaturalNumber(number: Int) =
        require(number > 0) { Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG }
}
