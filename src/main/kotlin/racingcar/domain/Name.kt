package racingcar.domain

class Name(val value: String) {

    init {
        require(value.length in 1..5) { "자동차 이름은 1자 이상이고, 5자를 초과할 수 없습니다." }
    }
}
