package step3.dto

import step3.model.Car

data class TrackResult(val moveResults: List<MoveResult>, val winnerCars: List<Car>)
