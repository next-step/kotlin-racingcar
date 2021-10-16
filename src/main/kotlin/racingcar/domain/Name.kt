package racingcar.domain

class Name(val name: String) {
    init {
        require(!name.isNullOrBlank())
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.")
        }
    }
}
