package racingcar.domain

import racingcar.util.extension.isPositive

@JvmInline
value class TryCount(private val count: Int) {
    fun getCount() = count

    init {
        require(count.isPositive()) { "입력 값은 1 이상이어야 합니다." }
    }

    companion object {
        @JvmStatic
        fun from(stringCount: String): TryCount {
            return TryCount(numberValidate(stringCount))
        }

        private fun numberValidate(stringCount: String): Int {
            return requireNotNull(stringCount.toIntOrNull()) { "입력 값은 정수 여야 합니다." }
        }
    }
}
