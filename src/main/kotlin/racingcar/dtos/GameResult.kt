package racingcar.dtos

data class GameResult(val roundResults: List<RoundResult>, val winners: List<CarDto>)
