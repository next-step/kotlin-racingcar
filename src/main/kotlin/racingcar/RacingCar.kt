package racingcar

const val MOVABLE_VALUE = 4
const val FIRST_QUESTION = "자동차 대수는 몇 대인가요?"
const val SECOND_QUESTION = "시도할 횟수는 몇 회인가요?"

fun main() {
    val carCount = InputView.getAnswerTo(FIRST_QUESTION)
    val tryCount = InputView.getAnswerTo(SECOND_QUESTION)
    RacingCar(carCount).race(tryCount)
}

class RacingCar constructor(carCount: Int) {
    val cars = mutableListOf<Car>()

    // RacingCar 인스턴스를 생성할때 몇개의 차를 만들것인지 정해 인스턴스 변수를 초기화 한다
    init {
        for (i in 1..carCount) {
            cars.add(Car())
        }
    }

    // n턴 경주시킨다
    fun race(tryCount: Int) {
        for (i in 1..tryCount) {
            // cars를 돌면서 각 Car 객체에게 전진하라고 명령
            moveForwardToCars()
            // 현재 차들의 상태를 프린트한다
            ResultView.view(cars)
        }
    }

    private fun moveForwardToCars() {
        cars.forEach {
            it.moveForward()
        }
    }
}
