package domain.racing

data class Name(var name: String) {

    init {
        validateName()
    }

    private fun validateName() {
        if (name.isBlank()) throw IllegalArgumentException("자동차 이름은 빈값일 수 없습니다.")
        if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}
