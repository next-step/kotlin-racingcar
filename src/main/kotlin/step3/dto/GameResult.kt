package step3.dto

data class GameResult(val moveResults: List<MoveResult>)

data class MoveResult(val carId: Int, val position: Int)
