package racingcar

object ResultView {
    private const val DISTANCE_MARK ="-"

    fun print(cars: MutableList<RacingCar>) {
        cars.forEach { car ->
            repeat(car.distance){
                print(DISTANCE_MARK)
            }
            println()
        }
        println()
    }
}
