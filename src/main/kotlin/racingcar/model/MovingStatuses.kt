package racingcar.model

class MovingStatuses(statuses: Collection<MovingStatus>) {

    constructor() : this(emptyList())

    private val statuses: Collection<MovingStatus> = statuses.toList()

    operator fun plus(status: MovingStatus) = MovingStatuses(statuses + status)

    val wentSize: Int get() = statuses.count { it == MovingStatus.GO }
}
