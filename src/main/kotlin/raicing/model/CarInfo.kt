package raicing.model

import raicing.Const

data class CarInfo(val name: String) {
    init {
        validName()
    }

    private fun validName() {
        require(name.isNotBlank()) { Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG }
        require(name.length <= MAX_NAME_LENGTH) { Const.ErrorMsg.CAR_NAME_IS_TOO_LONG }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
