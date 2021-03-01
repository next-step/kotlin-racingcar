package racing.data

data class RacingGameData(
    val carNames: List<String>,
    val tryCount: Int
) {
    val carCount: Int = carNames.size
}
