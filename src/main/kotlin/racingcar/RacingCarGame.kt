package racingcar

val RANDOM_RANGE = 0..9

fun main() {
    val numberOfCars = readNumberOfCars()
    val numberOfGames = readNumberOfGames()

    val carList: ArrayList<Car> = ArrayList()

    repeat(numberOfCars) {
        carList.add(Car())
        printDefaultPosition()
    }

    println()

    repeat(numberOfGames) {
        carList.forEach {
            it.move(RANDOM_RANGE.random())
            printCurrentPosition(it.position)
        }
        println()
    }
}
