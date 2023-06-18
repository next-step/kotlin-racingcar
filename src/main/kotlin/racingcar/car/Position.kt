package racingcar.car

private const val PATH_SIGN = "-"

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

    fun getPath(): String {
        return PATH_SIGN.repeat(position + 1)
    }
}
