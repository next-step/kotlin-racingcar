package racing.domain

data class Name(
    val name: String
) {

    init {
        require(name.isNotBlank()) { "자동차의 이름은 비어있을 수 없습니다." }
    }
}
