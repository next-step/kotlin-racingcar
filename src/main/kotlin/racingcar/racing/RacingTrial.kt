package racingcar.racing

import racingcar.racing.car.Car

data class RacingTrial(
    val order: TrialOrder,
    val records: List<Record>
) {
    val leadRecords: List<Record>
        get() = records.filter { it.isSameLocationAs(oneOfLeadRecord) }

    private val oneOfLeadRecord: Record
        get() = records.maxBy { it.location } ?: throw IllegalStateException(EMPTY_RECORDS_MESSAGE)

    init {
        require(records.isNotEmpty()) { EMPTY_RECORDS_MESSAGE }
    }

    fun checkOrder(index: Int) {
        order.check(index)
    }

    companion object {
        private const val EMPTY_RECORDS_MESSAGE = "records is empty!"

        fun of(order: Int, cars: Collection<Car>): RacingTrial {
            return RacingTrial(TrialOrder(order), cars.map { Record(it.name, it.location) })
        }
    }
}
