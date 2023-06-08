package step3.view

import step3.model.RaceGameErrorCode

data class RaceGameInput(
    val carNames: List<String>,
    val round: Int,
) {

    constructor(carNamesInput: String, roundInput: String) : this(
        carNames = carNamesInput.split(DELIMITER)
            .also {
                require(value = it.none { name -> name.length > MAX_NAME_SIZE }) {
                    RaceGameErrorCode.INVALID_CAR_NAME_INPUT.message(MAX_NAME_SIZE.toString())
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
