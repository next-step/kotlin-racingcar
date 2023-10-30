package racing.car.domain

object CarFactory {
    fun manufactureRacingCar(size: Int): List<Car> {
        return List(size) { RacingCar() }
    }
}
