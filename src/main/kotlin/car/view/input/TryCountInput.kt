package car.view.input

data class TryCountInput(val count: Int) {
    init {
        require(this.count >= MINIMUM_TRY_COUNT) { "최소 실행 횟수는 $MINIMUM_TRY_COUNT 회 이상입니다." }
    }

    constructor(count: String) : this(count.toInt())

    companion object {
        private const val MINIMUM_TRY_COUNT = 1
    }
}
