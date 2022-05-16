package racingcar

data class Rounds(val value: Int) {

    init {
        require(value > 0) { "경기 진행 수는 0보다 커야합니다." }
    }
}
