package car.view.input

import java.lang.IllegalArgumentException

class TryCountInput(count: String?) {
    val count: Int
    init {
        require(!count.isNullOrEmpty()) { "실행 횟수는 필수로 입력이 되어야 합니다. " }

        this.count = count.toIntOrNull() ?: throw IllegalArgumentException("실행 횟수는 숫자여야 합니다.")
        require(this.count >= MINIMUM_TRY_COUNT) { "최소 실행 횟수는 $MINIMUM_TRY_COUNT 회 이상입니다." }
    }

    companion object {
        const val MINIMUM_TRY_COUNT = 1
    }
}
