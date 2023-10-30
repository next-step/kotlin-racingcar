package step4.data

import step4.domain.GetWinnerList

data class RacingCourse(
    val tryCount: Int,
    val racingCars: List<RacingCar>
) {
    fun run(
        afterTrying: (RacingCar) -> Unit,
        afterOneRepeat: () -> Unit,
    ) {
        repeat(tryCount) {
            moveCarsInOneTry(afterTrying)
            afterOneRepeat()
        }
    }

    private fun moveCarsInOneTry(afterTrying: (RacingCar) -> Unit) {
        for (car in racingCars) {
            car.tryMoving()
            afterTrying(car)
        }
    }

    fun getWinnerList(): List<RacingCar> = GetWinnerList.getWinnerList(racingCars)
}
