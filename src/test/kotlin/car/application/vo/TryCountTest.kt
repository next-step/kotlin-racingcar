package car.application.vo

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll

class TryCountTest : StringSpec({
    "자동차 경주 시도횟수 생성" {
        tryCounts.forAll { shouldNotThrow<Throwable> { TryCount(it) } }
    }

    "자동차 경주 시도횟수가 0이하 일 경우 Exception을 던진다" {
        illegalTryCounts.forAll { shouldThrow<IllegalArgumentException> { TryCount(it) } }
    }
}) {
    companion object {
        private val tryCounts = listOf(1, 2, 3, 4)
        private val illegalTryCounts = listOf(0, -1)
    }
}
