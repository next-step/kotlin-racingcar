package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class StudyTest : StringSpec({

    "느낌표 두개는 null을 절대 허용하지 않는다" {
        val nullValue = null

        shouldThrow<NullPointerException> {
            nullValue!!
        }
    }

    "물음표는 null을 허용한다" {
        val nullValue = null

        val assignedNullValue: String? = nullValue

        assignedNullValue shouldBe null
    }

    "0에서 9사이의 값을 가지는 숫자를 생성한다 (`until` 마지막 값 미포함)" {
        (0..100).forEach { _ ->
            val randomNumber = (0 until 10).random()

            randomNumber shouldBeGreaterThanOrEqual 0
            randomNumber shouldBeLessThanOrEqual 9
        }
    }

    "0에서 9사이의 값을 가지는 숫자를 생성한다 (`..` 은 포함)" {
        (0..100).forEach { _ ->
            val randomNumber = (0..9).random()

            randomNumber shouldBeGreaterThanOrEqual 0
            randomNumber shouldBeLessThanOrEqual 9
        }
    }
})
