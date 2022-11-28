package racing.domain

private const val MAX_LENGTH_OF_NAME = 5

data class Name(
    val value: String
) {

    init {
        require(value.isNotBlank()) { "자동차의 이름은 비어있을 수 없습니다." }
        require(value.length <= MAX_LENGTH_OF_NAME) { "자동차의 이름은 ${MAX_LENGTH_OF_NAME}자를 초과할 수 없습니다. name: $value" }
    }
}
