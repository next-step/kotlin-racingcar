package racingcar.domain

data class RegisterResult(val participant: List<String>, val times: Int) {

    init {
        participant.forEach {
            require(it.isNotBlank()) { "자동차 이름은 공백이 될 수 없다." }
            require(it.length <= 5) { "자동차 이름은 5자를 초과할 수 없다." }
        }
        require(participant.isNotEmpty()) { "0대의 차로는 시작할 수 없습니다." }
        require(times != 0) { "0번의 횟수를 시도할 수 없습니다." }
    }
}
