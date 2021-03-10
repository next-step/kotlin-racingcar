package racingcar.domain

import racingcar.domain.car.Car

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
