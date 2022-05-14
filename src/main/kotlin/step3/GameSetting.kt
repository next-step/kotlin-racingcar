package step3

class GameSetting(
    val inputCarCount: Int,
    val inputMoveCount: Int
) {
    data class builder(
        private var inputCarCount: Int = 0,
        private var inputMoveCount: Int = 0
    ) {
        fun inputCarCount(inputCarCount: Int) = apply { this.inputCarCount = inputCarCount }
        fun inputMoveCount(inputMoveCount: Int) = apply { this.inputMoveCount = inputMoveCount }
        fun build() = GameSetting(inputCarCount, inputMoveCount)
    }
}
