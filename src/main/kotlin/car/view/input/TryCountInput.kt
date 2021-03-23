package car.view.input

data class TryCountInput(val count: Int) {
    init {
        require(this.count >= MINIMUM_TRY_COUNT) { "최소 실행 횟수는 $MINIMUM_TRY_COUNT 회 이상입니다." }
    }

    constructor(count: String?) : this(count.toInt())

    companion object {
        const val MINIMUM_TRY_COUNT = 1

        private fun String?.toInt(): Int {
            require(!this.isNullOrEmpty()) { "실행 횟수는 필수로 입력이 되어야 합니다. " }

            return toIntOrNull() ?: throw IllegalArgumentException("실행 횟수는 숫자여야 합니다.")
        }
    }
}
