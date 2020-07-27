package racingcar

object RacingCarFactory {
    fun makeCars(carNum: Int): List<RacingCar> = List(carNum) { RacingCar() }
}
