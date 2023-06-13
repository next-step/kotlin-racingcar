package racingcar.model

class MovingStatuses(statuses: Collection<MovingStatus>) {

    constructor() : this(emptyList())

    private val statuses: Collection<MovingStatus> = statuses.toList()

    val wentSize: Int get() = statuses.count { it == MovingStatus.GO }

    operator fun plus(status: MovingStatus) = MovingStatuses(statuses + status)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovingStatuses

        return statuses == other.statuses
    }

    override fun hashCode(): Int {
        return statuses.hashCode()
    }

    override fun toString(): String {
        return "MovingStatuses(statuses=$statuses)"
    }
}
