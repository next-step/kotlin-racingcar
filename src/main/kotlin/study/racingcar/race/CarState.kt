package study.racingcar.race

data class CarState(val name: String, val position: String) {
    fun getPositionLength(): Int {
        return position.length
    }
}
