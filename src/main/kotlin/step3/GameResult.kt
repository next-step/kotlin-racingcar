package step3

data class GameResult(val labResult: List<MoveResult>)

data class MoveResult(val carId: Int, val position: Int)
