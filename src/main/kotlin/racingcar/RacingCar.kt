package racingcar

// TODO 한번에 시도 횟수에 모든 자동차가 이동하는 방식으로 변경
// TODO tries와 자동차 위치 정보를 가지는 배열 또는 MutableList를 인스턴스 변수로 가지는 방식으로 구현하는 것은 어떨까?
// TODO 문자열 생성과 print를 분리하고 문자열 생성 부분에 대한 테스트 만들기

const val MOVABLE_VALUE = 4
const val FIRST_QUESTION = "자동차 대수는 몇 대인가요?"
const val SECOND_QUESTION = "시도할 횟수는 몇 회인가요?"

fun main() {
    val carCount = InputView.getAnswerTo(FIRST_QUESTION)
    val tryCount = InputView.getAnswerTo(SECOND_QUESTION)
    // carCount = 3, tryCount = 5 일때 각 자동차의 positionHistory를 기록한 리스트를 갖는 리스트를 리턴
    // result = [[1,2,3,3,3],[0,1,2,3,3],[1,1,1,1,2]]
    val result = RacingCar.race(carCount, tryCount)
    ResultView.view(result)
}

object RacingCar {
    fun race(carCount: Int, tries: Int): MutableList<List<Int>> {
        val cars = mutableListOf<List<Int>>()
        for (i in 1..carCount) {
            cars.add(Car().moveForward(tries))
        }
        return cars
    }
}

class Car {
    fun moveForward(tries: Int): List<Int> {
        val positionHistory = mutableListOf<Int>()
        var distance = 0
        for (i in 1..tries) {
            if (canMove()) distance++
            positionHistory.add(distance)
        }
        return positionHistory
    }

    private fun canMove(): Boolean {
        val randomValue = (0..9).random()
        return canMove(randomValue)
    }

    private fun canMove(randomValue: Int) = randomValue >= MOVABLE_VALUE
}
