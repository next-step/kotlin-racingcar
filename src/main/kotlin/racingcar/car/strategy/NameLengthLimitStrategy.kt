package racingcar.car.strategy

import racingcar.car.exception.InvalidDriverNameException

class NameLengthLimitStrategy : NameStrategy {
    override fun validateName(name: String) {
        if (invalidNameLength(name)) {
            throw InvalidDriverNameException(name, NAME_LENGTH_LIMIT)
        }
    }

    private fun invalidNameLength(name: String): Boolean {
        return name.length > NAME_LENGTH_LIMIT
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
