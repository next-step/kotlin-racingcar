package step4.carRacingWinner

object InputRule {
    val validateCarNames = { carNames: List<String> ->
        if (carNames.any { it.length < 6 }) {
            carNames
        } else {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다")
        }
    }
}
