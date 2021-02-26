package racingcar

fun main() {
    val numberOfCars = 3
    val count = 5

    val racingCar = RacingCar.ready(numberOfCars)
    for (i in 1..count) {
        racingCar.runOnce()
        racingCar.writeScores()
        println("-----------")
    }
    println("end")
}
