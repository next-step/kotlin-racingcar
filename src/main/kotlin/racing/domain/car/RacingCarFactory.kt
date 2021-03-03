package racing.domain.car

private const val MIN_PARTICIPANT = 2

class RacingCarFactory {
    companion object {
        fun createRacingCars(carNames: String): RacingCars {
            return RacingCars(createRacingCar(carNames))
        }

        private fun createRacingCar(carNames: String): List<RacingCar> {
            val tokens = carNames.split(",")
            validateParticipant(tokens)

            return tokens.map { name -> RacingCarName(name) }
                .map { racingCarName -> RacingCar(racingCarName) }
                .toList()
        }

        private fun validateParticipant(tokens: List<String>) {
            require(tokens.size >= MIN_PARTICIPANT) { "참가자는 2명 이상이어야 합니다." }
        }
    }
}
