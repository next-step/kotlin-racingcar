package racingcar.domain.vo

@JvmInline
value class Lap private constructor(val round: Int) {
    companion object {
        fun of(round: Int): Lap {
            require(round >= 1) { "레이스 라운드는 1보다 작을 수 없습니다." }
            return Lap(round)
        }
        fun initialize() = Lap(0)
    }
}
