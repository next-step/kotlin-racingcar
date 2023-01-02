package domain.racing

data class Name(val name: String) {

    init {
        validateName()
    }

    private fun validateName() {
        require(name.isNotBlank()) { "자동차 이름은 빈값일 수 없습니다." }
        require(name.length < MAX_NAME_SIZE) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_SIZE = 6
    }
}
