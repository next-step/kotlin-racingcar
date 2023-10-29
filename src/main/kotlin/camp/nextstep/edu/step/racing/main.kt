package camp.nextstep.edu.step.racing

import camp.nextstep.edu.step.racing.service.CarService
import camp.nextstep.edu.step.racing.service.RacingTrackService
import camp.nextstep.edu.step.racing.service.TournamentService
import camp.nextstep.edu.step.racing.strategy.RandomMoveStrategy
import camp.nextstep.edu.step.racing.ui.InputView


fun main() {
    val inputCarNames = InputView.inputCarNames()
    val inputTryCount = InputView.inputTryCount()
    val inputTournamentName = InputView.inputTournamentName()
    val inputTrackName = InputView.inputTrackName()

    val createTournament = TournamentService(
        CarService(RandomMoveStrategy()),
        RacingTrackService
    ).createTournament(
        carNames = inputCarNames,
        racingTrackName = inputTrackName,
        tryCount = inputTryCount,
        tournamentName = inputTournamentName
    )

    TournamentService(
        CarService(RandomMoveStrategy()),
        RacingTrackService
    ).startTournamentRace(tournament = createTournament)

}
