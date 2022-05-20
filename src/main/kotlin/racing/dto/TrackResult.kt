package racing.dto

import racing.model.Car

data class TrackResult(val moveResults: List<MoveResult>, val winnerCars: List<Car>)
