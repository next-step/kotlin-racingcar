package step3.input.value

data class PlayTime(private val playTime: Int) {
    init {
        require(playTime > 0) { "시도 횟수는 0보다 커야 합니다." }
    }

    fun getPlayTime(): Int {
        return playTime
    }
}
