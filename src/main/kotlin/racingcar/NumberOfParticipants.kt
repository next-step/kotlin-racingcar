package racingcar

data class NumberOfParticipants(val value: Int) {

    init {
        require(value > 0) { "참가자 수는 0보다 커야합니다." }
    }
}
