package racing

private const val MIN_ROUND = 0

@JvmInline
value class Round(val value: Int) {
    init {
        require(value > MIN_ROUND) { RoundException("라운드는 양의 정수입니다.") }
    }
}
