package racing.ui.model

import racing.data.CarState

data class CarStateDTO(
    val name: String,
    val position: Int
) {
    companion object {
        fun of(carState: CarState): CarStateDTO {
            return CarStateDTO(carState.name.name, carState.position.position)
        }
    }
}
