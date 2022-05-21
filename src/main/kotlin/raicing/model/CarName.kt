package raicing.model

import raicing.Const

@JvmInline
value class CarName(private val value: String) {
    init {
        validName()
    }

    override fun toString(): String = value

    private fun validName() {
        require(value.isNotBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        require(value.length <= MAX_NAME_LENGTH) { Const.ErrorMsg.CAR_NAME_IS_TOO_LONG }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
