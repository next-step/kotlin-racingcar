package racing.domain.car

fun createRacingCar(name: String) = RacingCar(RacingCarName(name))

fun createRacingCar(name: String, position: Int) = RacingCar(
    RacingCarName(name), position
)