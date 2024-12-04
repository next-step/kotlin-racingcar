package racing.model

import racing.view.input.ConsoleInputView.Companion.DEFAULT_NAME_MAX
import racing.view.input.ConsoleInputView.Companion.DELIMITER_COMMA

object InputValidator {
    fun requireValidCarNamesInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "입력값을 확인해주세요." }
        require(input.split(DELIMITER_COMMA).none { it.trim().length > DEFAULT_NAME_MAX }) {
            "자동차 이름은 ${DEFAULT_NAME_MAX}자를 초과할 수 없습니다."
        }
        return input
    }

    fun requireValidAttemptCountInput(input: String?): String {
        require(!input.isNullOrEmpty()) { "입력값을 확인해주세요." }
        require(input.toIntOrNull() != null) { "숫자를 입력해주세요." }
        require(input.toInt() > 0) { "최소 0보다 큰수를 입력해주세요." }
        return input
    }
}
