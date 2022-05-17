package step3.dto

import step3.model.Car

data class TrackResult(val moveResults: List<MoveResult>) {
    fun getWinners(): List<Car> {
        return moveResults
            .groupBy({ it.position }, { it.car })
            .maxByOrNull { it.key }?.value ?: listOf()
    }
}
