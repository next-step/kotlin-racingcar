package racingcar

val ATTEMPT_NUMBER_RANGE = 0..9

fun main() {
    val numberOfCars = readNumberOfCars()
    val numberOfGames = readNumberOfGames()

    val carList: MutableList<Car> = ArrayList()

    repeat(numberOfCars) {
        carList.add(Car())
        printDefaultPosition()
    }

    println()

    repeat(numberOfGames) {
        carList.forEach {
            it.move(ATTEMPT_NUMBER_RANGE.random())
            printCurrentPosition(it.position)
        }
        println()
    }
}
