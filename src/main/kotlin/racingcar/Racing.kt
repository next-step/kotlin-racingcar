package racingcar

fun main() {
    Racing().start()
}

class Racing {

    fun start() {
        val carCount = inputCarCount()
        val tryCount = inputTryCount()
        val cars = createCars(carCount)

        println("실행 결과")
        repeat(tryCount) {
            cars.forEach { car ->
                car.drive()
                car.printPosition()
            }
            println()
        }
    }

    private fun createCars(carCount: Int) =
        Array(carCount) { index -> Car(index) }

    private fun inputCarCount(): Int {
        println("자동차 대수는 몇 대인가요?")

        return readlnOrNull()?.toInt() ?: run {
            println("필수로 입력해야 하는 값입니다.")
            inputCarCount()
        }
    }

    private fun inputTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readlnOrNull()?.toInt() ?: run {
            println("필수로 입력해야 하는 값입니다.")
            inputTryCount()
        }
    }
}
