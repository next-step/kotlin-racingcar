package racing.view

import racing.model.RaceGameErrorCode

data class RaceGameInput(
    val carNames: List<String>,
    val round: Int,
) {

    constructor(carNamesInput: String, roundInput: String) : this(
        carNames = carNamesInput.split(DELIMITER),
        round = requireNotNull(value = roundInput.toIntOrNull()) {
            RaceGameErrorCode.INVALID_ROUND_INPUT.message(roundInput)
        },
    )

    companion object {
        private const val DELIMITER = ','
    }
}
