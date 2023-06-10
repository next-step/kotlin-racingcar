package step3.domain

/**
 * ### 레이싱에 참여하는 자동차를 담은 일급 컬렉션입니다.
 *
 * 실제 레이싱를 수행하고 레이싱 기록을 반환합니다.
 */
class RacingCars(private val cars: List<Car>) {

    fun race(attemptCount: Int): RacingRecord {
        val record = mutableListOf<List<Int>>()
        repeat(attemptCount) {
            val tryResult: List<Int> = attemptToMoveCars()
            record.add(tryResult)
        }
        return RacingRecord(record)
    }

    private fun attemptToMoveCars(): List<Int> {
        return cars.map { car ->
            car.move(RandomGenerator.next0To9())
            car.position
        }
    }
}
