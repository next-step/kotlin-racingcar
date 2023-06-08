package step3.view

import step3.model.RaceGameErrorCode

data class RaceGameInput(
    val carNames: List<String>,
    val round: Int,
) {

    constructor(carNamesInput: String, roundInput: String) : this(
        carNames = carNamesInput.split(DELIMITER)
            .onEach { name ->
                require(value = name.length <= MAX_NAME_SIZE && name.isNotBlank()) {
                    RaceGameErrorCode.INVALID_CAR_NAME_INPUT.message("$name$DELIMITER $MAX_NAME_SIZE")
                }
            },

        round = requireNotNull(value = roundInput.toIntOrNull()) {
            RaceGameErrorCode.INVALID_ROUND_INPUT.message(roundInput)
        },
    )

    companion object {
        private const val DELIMITER = ','
        private const val MAX_NAME_SIZE = 5
    }
}
