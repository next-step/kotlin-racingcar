package racingcar.exception.message.input

import racingcar.exception.message.Message

enum class InputErrorMessage(override val message: String) : Message {
    NOT_NUMBER("숫자만 입력 할 수 있습니다."),
    OUT_OF_RANGE("범위를 벗어 났습니다. 0 을 초과하는 값을 입력해주세요.")
}
