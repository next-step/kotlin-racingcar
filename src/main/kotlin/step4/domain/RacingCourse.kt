package step4.domain

data class RacingCourse(
    val tryCount: Int,
    val racingCars: RacingCars
) {
    fun moveCars(moveStrategy: MoveStrategy = RandomStrategy(), afterOneTry: (RacingCars) -> Unit) {
        repeat(tryCount) {
            for (car in racingCars.carList) {
                car.tryMoving(moveStrategy)
            }

            afterOneTry(racingCars)
        }
    }
}
