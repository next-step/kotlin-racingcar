package racingcar.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row

class TryCountTest : StringSpec({

    val tryCount = TryCount()

    "시도 횟수 예외 확인" {
        forAll(
            row(0),
        ) { userTryCount ->
            shouldThrow<IllegalArgumentException> {
                tryCount.getTryCount(userTryCount)
            }
        }
    }
})
