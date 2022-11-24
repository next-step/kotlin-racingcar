package racingcar.domain

@JvmInline
value class Round(private val round: Int) {

    init {
        require(round >= 0) { "라운드 숫자는 음수가 될수없습니다." }
    }
}