package racingcar.domain

import racingcar.util.extension.isPositive

@JvmInline
value class TryCount private constructor(private val count: Int) {
    fun getCount() = count

    companion object {
        @JvmStatic
        fun from(stringCount: String) = TryCount(validate(stringCount))

        @JvmStatic
        private fun validate(stringCount: String): Int {
            val count: Int = requireNotNull(stringCount.toIntOrNull()) { "입력 값은 정수 여야 합니다." }
            require(count.isPositive()) { "입력 값은 1 이상이어야 합니다." }
            return count
        }
    }
}
