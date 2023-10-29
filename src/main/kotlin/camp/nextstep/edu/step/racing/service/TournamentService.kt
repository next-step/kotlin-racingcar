package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.Car
import camp.nextstep.edu.step.racing.domain.Tournament
import camp.nextstep.edu.step.racing.domain.TournamentFinishStatus
import camp.nextstep.edu.step.racing.dto.CreateTonamentDto
import camp.nextstep.edu.step.racing.ui.ResultView
import java.util.stream.Collectors

class TournamentService(
    private val carService: CarService,
    private val racingTrackService: RacingTrackService
) {
    fun createTournament(
        createTonament: CreateTonamentDto
    ): Tournament {
        val participateCars = splitCarNameAndCreateCar(carNames = createTonament.carName)

        val racingTrack = racingTrackService.createRacingTrack(trackName = createTonament.racingTrackName)

        return Tournament(
            tournamentName = createTonament.tournamentName,
            track = racingTrack,
            tournamentInformation = Tournament.TournamentInformation(
                cars = participateCars,
                tryCount = createTonament.tryCount
            )
        )
    }

    fun startTournamentRace(tournament: Tournament): TournamentFinishStatus {
        val cars = tournament.getCarListInTournament()

        repeat(tournament.getTryCount()) {
            cars.forEach { car ->
                carService.carMoveByMoveStrategy(car = car)
            }
            ResultView.disPlayCarMoveResult(cars = cars)
        }

        val winners = voteToWinner(cars = cars)

        return validateTiesOrSoloWinner(cars = winners, tournament = tournament)
    }

    private fun splitCarNameAndCreateCar(carNames: String): List<Car> {
        return carNames.split(",").stream().map { carName ->
            carService.createCarByInput(carName = carName)
        }.collect(Collectors.toList())
    }

    private fun validateTiesOrSoloWinner(cars: List<Car>, tournament: Tournament): TournamentFinishStatus {
        return if (cars.size > 1) {
            ResultView.displayTournamentJointWinnerResult(
                tournament = tournament,
                winners = cars
            )
            TournamentFinishStatus.activeTrue()
        } else {
            ResultView.displayTournamentAloneWinnerResult(
                tournament = tournament,
                winner = cars.first()
            )
            TournamentFinishStatus.activeTrue()
        }

    }

    private fun voteToWinner(cars: List<Car>): List<Car> {
        val winnerCar = cars.maxByOrNull { car -> car.position }!!

        return cars.filter { car -> car.position == winnerCar.position }
    }

}
