package step3.domain.game.history

import step3.domain.game.RacingGame

class RacingGameHistory(racingGame: RacingGame) {

    val racingCarHistoryList: List<RacingCarHistory> = racingGame.carList.map { RacingCarHistory(it) }.toList()
}
