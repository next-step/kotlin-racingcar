class Car {
    private val _record = mutableListOf<String>()

    fun move() {
        _record.add(MOVE)
    }

    fun stop() {
        _record.add(STOP)
    }

    fun getMoved(): Int {
        return _record.filter { it.equals(MOVE) }.count()
    }

    companion object {
        private const val MOVE = "move"
        private const val STOP = "stop"
    }
}
