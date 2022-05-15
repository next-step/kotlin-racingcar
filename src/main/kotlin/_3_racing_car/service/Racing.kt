package _3_racing_car.service

class Racing {
    fun run(racingInput: RacingInputDto): List<Int> = racingInput.tracks.map {
        it.run(racingInput.times)
    }
}
