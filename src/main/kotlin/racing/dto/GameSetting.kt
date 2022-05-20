package racing.dto

class GameSetting(
    val carNames: List<String>,
    val moveCount: Int
) {
    data class Builder(
        private var inputCarNames: List<String> = listOf(),
        private var inputMoveCount: Int = 0
    ) {
        fun inputCarNames(inputCarNames: List<String>) = apply { this.inputCarNames = inputCarNames }
        fun inputMoveCount(inputMoveCount: Int) = apply { this.inputMoveCount = inputMoveCount }
        fun build() = GameSetting(inputCarNames, inputMoveCount)
    }
}
