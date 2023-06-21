package racingcar.domain

private const val DEFAULT_POSITION: Int = 0
private const val PATH_SIGN = "-"

data class Position(private var position: Int = DEFAULT_POSITION) {

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
