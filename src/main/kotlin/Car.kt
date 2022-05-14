class Car(val carName: String) {
    private val _record = mutableListOf<MovingStatus>()
    private var name = ""

    init {
        this.name = carName
    }

    fun move() {
        _record.add(MovingStatus.MOVE)
    }

    fun stop() {
        _record.add(MovingStatus.STOP)
    }

    fun getMoved(): Int {
        return _record.filter { it.equals(MovingStatus.MOVE) }.count()
    }
}
