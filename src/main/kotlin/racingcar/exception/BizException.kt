package racingcar.exception

import racingcar.exception.message.Message

sealed class BizException(message: String) : IllegalArgumentException(message) {
    class InputException(inputErrorMessage: Message) : BizException(inputErrorMessage.message)
}
