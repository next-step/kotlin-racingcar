package _3_racing_car.domain

class Name(value: String) {
    init {
        validateBlank(value)
        validateSize(value)
    }

    private fun validateBlank(value: String) = require(value.isNotBlank()) { "공백이 이름이 될수 없습니다. name=$value" }
    private fun validateSize(value: String) = require(value.length <= MAX_NAME_SIZE) { "이름은 ${MAX_NAME_SIZE}자를 초과할 수 없습니다. name=$value" }

    companion object {
        private const val MAX_NAME_SIZE = 5
    }
}
