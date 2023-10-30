package step4.domain

data class RacingCourse(
    val tryCount: Int,
    val racingCars: RacingCars
) {
    fun moveCars(afterOneTry: (RacingCars) -> Unit) {
        repeat(tryCount) {
            for (car in racingCars.racingCars) {
                car.tryMoving()
            }

            afterOneTry(racingCars)
        }
    }
}
