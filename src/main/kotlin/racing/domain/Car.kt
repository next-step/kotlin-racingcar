package racing.domain

class Car(val carName: String) {
    private val record = mutableListOf<MovingStatus>()

    fun move() {
        record.add(MovingStatus.MOVE)
    }

    fun stop() {
        record.add(MovingStatus.STOP)
    }

    fun getMoved(): Int {
        return record.filter { it.equals(MovingStatus.MOVE) }.count()
    }
}
