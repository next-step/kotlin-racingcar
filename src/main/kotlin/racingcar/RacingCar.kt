package racingcar

const val FIRST_QUESTION = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
const val SECOND_QUESTION = "시도할 횟수는 몇 회인가요?"

fun main() {
    val carNames = InputView.getCarNames(FIRST_QUESTION)
    val tryCount = InputView.getAnswerTo(SECOND_QUESTION)
    RacingCar(carNames).race(tryCount)
}

class RacingCar(carNames: List<String>) {
    val cars = mutableListOf<Car>()
    val winnerCars = mutableListOf<Car>()

    init {
        carNames.forEach {
            cars.add(Car(it))
        }
    }

    fun race(tryCount: Int) {
        for (i in 1..tryCount) {
            moveForwardToCars()
            // 현재 차들의 상태를 프린트한다
            ResultView.view(cars)
        }
        val winner = getWinner(cars)
        ResultView.viewWinner(winner)
    }

    private fun getWinner(cars: List<Car>): List<Car> {
        val max = cars.maxBy { it.currentPosition }!!.currentPosition
        cars.forEach {
            if (max == it.currentPosition) winnerCars.add(it)
        }
        return winnerCars
    }

    private fun moveForwardToCars() {
        cars.forEach {
            it.moveForward()
        }
    }
}
