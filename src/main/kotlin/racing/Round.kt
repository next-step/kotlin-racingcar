package racing

@JvmInline
value class Round private constructor(val round: Int) {
    companion object {
        fun make(count: Int): Round {
            require(count > 0) {
                "양수만 가능합니다."
            }
            return Round(count)
        }
    }
}
