package racingcar.domain.vo

@JvmInline
value class Lap(val round: Int) {
    init {
        require(round >= 1) { "레이스 라운드는 1보다 작을 수 없습니다." }
    }
}
