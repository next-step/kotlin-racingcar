package racingcar.domain

@JvmInline
value class Round(val value: Int) {
    init {
        require(value > 0) { "라운드는 0보다 커야합니다." }
    }
}
