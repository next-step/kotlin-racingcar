package racingcar.domain.racing

import racingcar.domain.car.Car

data class RacingTrial(
    val order: TrialOrder,
    val records: List<Record>
) {
    val leadRecords: List<Record>
        get() {
            val sampleLeadRecord = findOneOfLeadRecord()
            return records.filter { it.isSameLocationAs(sampleLeadRecord) }
        }

    private fun findOneOfLeadRecord(): Record = records.maxBy { it.location }
        ?: throw IllegalStateException(EMPTY_RECORDS_MESSAGE)

    init {
        require(records.isNotEmpty()) { EMPTY_RECORDS_MESSAGE }
    }

    constructor(order: Int, cars: List<Car>) : this(
        order = TrialOrder(order),
        records = cars.map { Record(it.name, it.location) }
    )

    fun checkOrder(index: Int) {
        this.order.checkOrder(index)
    }

    companion object {
        private const val EMPTY_RECORDS_MESSAGE = "records is empty!"
    }
}
