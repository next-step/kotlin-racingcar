package racing.domain

class CarName(
    val name: String
) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5 글자를 초과할 수 없습니다." }
        require(name.isNotBlank()) { "이름은 빈값을 입력할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
