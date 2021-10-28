package racingcar

val RANDOM_RANGE = 0..9

fun main() {
    val numberOfCars = readNumberOfCars()
    val numberOfGames = readNumberOfGames()

    val carList: ArrayList<Car> = ArrayList()

    repeat(numberOfCars) {
        carList.add(Car())
    }

    println()

    repeat(numberOfGames) {
        carList.forEach {
            it.move(RANDOM_RANGE.random())
        }
        println()
    }
}

class Car(var position: Int = DEFAULT_POSITION) {
    init {
        printDefaultPosition()
    }

    fun move(randomValue: Int) {
        require(randomValue in RANDOM_RANGE) { "전진 시도 숫자는 0과 9사이의 값이어야 합니다." }
        if (randomValue >= MOVE_THRESHOLD) {
            position++
        }
        printCurrentPosition()
    }

    private fun printDefaultPosition() {
        println(CAR_CHARACTER)
    }

    private fun printCurrentPosition() {
        repeat(position) {
            print(CAR_CHARACTER)
        }
        println()
    }

    companion object {
        const val DEFAULT_POSITION = 1
        const val MOVE_THRESHOLD = 4
        const val CAR_CHARACTER = '-'
    }
}
