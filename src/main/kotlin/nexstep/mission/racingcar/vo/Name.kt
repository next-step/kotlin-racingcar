package nexstep.mission.racingcar.vo

data class Name(val value: String) {
    init {
        require(this.value.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }
}
