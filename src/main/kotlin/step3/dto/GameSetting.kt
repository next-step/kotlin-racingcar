package step3.dto

class GameSetting(
    val carCount: Int,
    val moveCount: Int
) {
    data class Builder(
        private var inputCarCount: Int = 0,
        private var inputMoveCount: Int = 0
    ) {
        fun inputCarCount(inputCarCount: Int) = apply { this.inputCarCount = inputCarCount }
        fun inputMoveCount(inputMoveCount: Int) = apply { this.inputMoveCount = inputMoveCount }
        fun build() = GameSetting(inputCarCount, inputMoveCount)
    }
}
