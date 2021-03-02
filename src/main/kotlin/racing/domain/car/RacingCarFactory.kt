package racing.domain.car

class RacingCarFactory {
    companion object {
        fun createRacingCars(carNames: String): RacingCars {
            return RacingCars(createRacingCar(carNames))
        }

        private fun createRacingCar(carNames: String): List<RacingCar> {
            val tokens = carNames.split(",")

            return tokens.map { name -> RacingCarName(name) }
                .map { racingCarName -> RacingCar(racingCarName) }
                .toList()
        }
    }
}
