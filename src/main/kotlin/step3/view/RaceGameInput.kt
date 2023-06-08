package step3.view

import step3.model.RaceGameErrorCode

data class RaceGameInput(
    val carCount: Int,
    val round: Int,
) {

    constructor(carCountInput: String, roundInput: String) : this(
        carCount = requireNotNull(value = carCountInput.toIntOrNull()) {
            RaceGameErrorCode.INVALID_CAR_COUNT_INPUT.message(carCountInput)
        },

        round = requireNotNull(value = roundInput.toIntOrNull()) {
            RaceGameErrorCode.INVALID_CAR_COUNT_INPUT.message(roundInput)
        },
    )
}
