package calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

internal class NumberTest : FreeSpec({

    "정수 이외의 문자열로 Number 변환을 시도하면 예외가 발생한다." - {
        listOf(
            "",
            " ",
            "zz"
        ).forEach { invalidString ->
            "\"$invalidString\" 은 Number로 변환에 실패한다." {
                // when
                val exception = shouldThrowExactly<NumberFormatException> { Number.from(invalidString) }

                // then
                exception.message shouldBe "For input string: \"$invalidString\""
            }
        }
    }
})
