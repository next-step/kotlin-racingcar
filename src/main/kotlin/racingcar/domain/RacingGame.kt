package racingcar.domain

import kotlin.random.Random

class RacingGame(
    val carSize: Int,
    val attemptSize: Int
) {
    private val cars = List(carSize) { Car() }
    private var curAttemptNum: Int = 0
    private val _history: MutableList<List<Int>> = mutableListOf()
    val history: List<List<Int>>
        get() = _history

    fun attempt() {
        check(curAttemptNum < attemptSize) { "시도 횟수를 초과했습니다." }

        cars.forEach {
            it.move(Random.nextInt(10))
        }
        _history.add(cars.map { it.position })
        curAttemptNum++
    }
}
