package racingcar.domain

import racingcar.domain.model.Cars

class GameResults(private val gameResults: List<Cars>) {

    init {
        require(gameResults.isNotEmpty()) { "게임 결과가 존재해야 합니다" }
    }

    fun findMostFarthestCar(): Cars {
        return gameResults.last().findMostFarthestCar()
    }

    fun forEach(action: (Cars) -> Unit) = gameResults.forEach(action)
}
