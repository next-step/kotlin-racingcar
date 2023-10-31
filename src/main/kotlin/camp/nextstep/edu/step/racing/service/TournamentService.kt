package camp.nextstep.edu.step.racing.service

import camp.nextstep.edu.step.racing.domain.Cars
import camp.nextstep.edu.step.racing.domain.Tournament
import camp.nextstep.edu.step.racing.dto.CreateTonamentDto
import java.util.stream.Collectors

class TournamentService(
    private val carService: CarService,
    private val racingTrackService: RacingTrackService
) {
    fun createTournament(
        createTonament: CreateTonamentDto
    ): Tournament {
        val participateCars = splitCarNameAndCreateCar(inputCarValue = createTonament.carName)

        val racingTrack =
            racingTrackService.createRacingTrack(trackName = createTonament.racingTrackName)

        return Tournament(
            tournamentName = createTonament.tournamentName,
            track = racingTrack,
            tournamentInformation = Tournament.TournamentInformation(
                cars = participateCars,
                tryCount = createTonament.tryCount
            )
        )
    }

    private fun splitCarNameAndCreateCar(inputCarValue: String): Cars {
        val createCars = inputCarValue.split(",").stream().map { value ->
            carService.createCarByInput(inputCarValue = value)
        }.collect(Collectors.toList())

        return Cars.of(cars = createCars)
    }

}
