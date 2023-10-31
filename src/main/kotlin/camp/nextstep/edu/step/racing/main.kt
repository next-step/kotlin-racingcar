package camp.nextstep.edu.step.racing

import camp.nextstep.edu.step.racing.dto.CreateTonamentDto
import camp.nextstep.edu.step.racing.facade.RacingFacade
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

    val createTonamentDto = CreateTonamentDto(
        carName = inputCarNames,
        racingTrackName = inputTrackName,
        tournamentName = inputTournamentName,
        tryCount = inputTryCount
    )

    RacingFacade(
        TournamentService(
            CarService(RandomMoveStrategy()),
            RacingTrackService
        ),
        CarService(RandomMoveStrategy())
    ).playRacingGame(
        createTonamentDto = createTonamentDto
    )

}
