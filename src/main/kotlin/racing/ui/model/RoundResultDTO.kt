package racing.ui.model

import racing.data.RoundResult

data class RoundResultDTO(
    val carStateDTOs: List<CarStateDTO>
) {
    companion object {
        fun of(roundResult: RoundResult): RoundResultDTO {
            val carStates = roundResult.carStates
            val carStateDTOs = carStates.map { CarStateDTO.of(it) }.toList()
            return RoundResultDTO(carStateDTOs)
        }
    }
}
