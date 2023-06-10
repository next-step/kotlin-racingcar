package racing.domain.dto

import racing.domain.Capacity
import racing.domain.Name

data class RacingGameRequest(
    val carNames: List<String>,
    val numberOfRound: Int
) {
    init {
        validateCarNames(carNames)
        validateNumberOfRound(numberOfRound)
    }

    private fun validateCarNames(carNames: List<String>) {
        val distinctCarNames = carNames.map { it.trim() }.distinct().toSet()

        require(carNames.size == distinctCarNames.size) {
            "자동차 이름은 중복될 수 없습니다."
        }

        require(carNames.all { it.length <= Name.NAME_LENGTH_LIMIT }) {
            "자동차 이름은 $Name.NAME_LENGTH_LIMIT 보다 짧아야 합니다."
        }
    }

    private fun validateNumberOfRound(numberOfRound: Int) {
        require(numberOfRound > 0) {
            "${Capacity.INVALID_CAPACITY_MESSAGE} $numberOfRound"
        }
    }
}
