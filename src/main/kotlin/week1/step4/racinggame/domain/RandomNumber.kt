package week1.step4.racinggame.domain

@JvmInline
value class RandomNumber(val value: Int) {
    init {
        require(value in 0..9) {
            "0-9 사이의 randomNumber 가 아닙니다: randomNumber=$value"
        }
    }
}
