package car.ui

inline class NumberOfCar(val value: Int)

inline class TryCount(val value: Int)

object InputView {
    fun input(): Pair<NumberOfCar, TryCount> {
        println("자동차 대수는 몇 대 인가요 ?")
        val numberOfCar =
            readln().toIntOrNull()?.let { NumberOfCar(it) } ?: throw IllegalArgumentException("자동차 대수는 숫자만 입력 가능합니다.")

        println("시도할 횟수는 몇 회인가요 ?")
        val tryCount =
            readln().toIntOrNull()?.let { TryCount(it) } ?: throw IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.")

        return numberOfCar to tryCount
    }
}
