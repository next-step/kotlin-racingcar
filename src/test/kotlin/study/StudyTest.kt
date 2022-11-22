package study

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
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
})
