package racingcar.car

data class Position(private var position: Int) {

    init {
        require(position >= 0) { "음수는 입력할 수 없습니다." }
    }

    fun add() {
         this.position += 1
    }

    fun getPosition(): Int {
        return position
    }
}
