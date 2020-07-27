package week1.step3

object ResultView {

    fun printEachCarMovingState(racingCar: Array<Car>) {
        racingCar.forEach { car ->
            for (cnt in 0 until car.forwardCount) {
                print("-")
            }
            println()
        }
    }
}
