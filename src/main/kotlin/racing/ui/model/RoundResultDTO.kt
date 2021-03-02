package racing.ui.model

import racing.data.RoundResult

data class RoundResultDTO(
    val carStateDTOs: List<CarStateDTO>
) {
    companion object {
        fun from(roundResult: RoundResult): RoundResultDTO {
            val carStates = roundResult.carStates
            val carStateDTOs = carStates.map { CarStateDTO.from(it) }.toList()
            return RoundResultDTO(carStateDTOs)
        }
    }
}
