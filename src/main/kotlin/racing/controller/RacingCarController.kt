package racing.controller

import racing.domain.GameCount
import racing.domain.Players
import racing.domain.Race
import racing.domain.RandomMovingStrategy
import racing.ui.InputView.inputGameCount
import racing.ui.InputView.inputPlayers
import racing.ui.OutputView

class RacingCarController {
    fun playGame() {
        val race = Race(
            getPlayers(),
            getGameCount(),
            RandomMovingStrategy()
        )
        OutputView.printGameResult()
        while (race.onPlay()) {
            OutputView.printResultPerRace(race.run())
        }
        OutputView.printWinner(race.winners)
    }

    private fun getGameCount(): GameCount {
        return try {
            GameCount(inputGameCount())
        } catch (e: IllegalArgumentException) {
            OutputView.printIllegalArgumentException(e)
            getGameCount()
        }
    }

    private fun getPlayers(): Players {
        return try {
            Players(inputPlayers())
        } catch (e: IllegalArgumentException) {
            OutputView.printIllegalArgumentException(e)
            getPlayers()
        }
    }
}
