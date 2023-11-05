package racing

fun main() {
    val inputView = InputView()
    val numberOfCars = inputView.get("자동차 대수는 몇 대인가요?")
    val tryCount = inputView.get("시도할 횟수는 몇 회인가요?")

    Game(numberOfCars, tryCount).start()
}

class InputView {
    fun get(prompt: String): Int {
        print(prompt)
        val input = readln()
        val inputValue = input?.toIntOrNull()
        if (inputValue != null) {
            return inputValue
        } else {
            println("다시 입력해 주세요.")
            return get(prompt)
        }
    }
}

class ResultView {
    fun view(carList: List<Car>) {
        carList.forEach {
            repeat(it.position) {
                print("-")
            }
            println("")
        }
        println("")
    }
}

class Game(
    private val numberOfCar: Int,
    private val tryCount: Int
) {
    private val carList = mutableListOf<Car>()
    private val resultView = ResultView()

    fun start() {
        repeat(numberOfCar) {
            carList.add(Car())
        }

        repeat(tryCount) {
            run()
        }
    }

    private fun run() {
        carList.forEach {
            it.move()
        }

        resultView.view(carList)
    }
}
