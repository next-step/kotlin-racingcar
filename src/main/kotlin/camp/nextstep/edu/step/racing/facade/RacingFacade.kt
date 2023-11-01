package camp.nextstep.edu.step.racing.facade

import camp.nextstep.edu.step.racing.domain.Cars
import camp.nextstep.edu.step.racing.domain.Tournament
import camp.nextstep.edu.step.racing.domain.TournamentFinishStatus
import camp.nextstep.edu.step.racing.dto.CreateTonamentDto
import camp.nextstep.edu.step.racing.service.CarService
import camp.nextstep.edu.step.racing.service.TournamentService
import camp.nextstep.edu.step.racing.ui.ResultView

class RacingFacade(
    private val tournamentService: TournamentService,
    private val carService: CarService
) {

    fun playRacingGame(createTonamentDto: CreateTonamentDto): TournamentFinishStatus {
        val createTournament =
            tournamentService.createTournament(createTonament = createTonamentDto)
        val cars = createTournament.getCars()

        repeat(createTournament.getTryCount()) {
            cars.moveCarsByMoveStrategy(carService = carService)
            ResultView.disPlayCarMoveResult(
                cars = cars
            )
        }
        val winners = cars.getWinners()

        return validateTiesOrSoloWinner(
            cars = winners,
            tournament = createTournament
        )

    }

    private fun validateTiesOrSoloWinner(
        cars: Cars,
        tournament: Tournament
    ): TournamentFinishStatus {
        return if (cars.getCarsSize() > 1) {
            ResultView.displayTournamentJointWinnerResult(
                tournament = tournament,
                winners = cars.cars
            )
            TournamentFinishStatus.activeTrue()
        } else {
            ResultView.displayTournamentAloneWinnerResult(
                tournament = tournament,
                winner = cars.getFirstCar()
            )
            TournamentFinishStatus.activeTrue()
        }
    }

}
