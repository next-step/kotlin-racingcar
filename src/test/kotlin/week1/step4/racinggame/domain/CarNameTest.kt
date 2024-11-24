package week1.step4.racinggame.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class CarNameTest : StringSpec({
    "CarName 은 Empty 문자열을 이름으로 쓸 수 없다" {
        val value = ""
        shouldThrow<IllegalArgumentException> {
            CarName(value)
        }
    }

    "CarName 은 Blank 문자열을 이름으로 할 수 없다" {
        val value = " "
        shouldThrow<IllegalArgumentException> {
            CarName(value)
        }
    }

    "Car는 5글자를 초과하는 이름을 가질 수 없다" {
        val value = "sixman"
        shouldThrow<IllegalArgumentException> {
            CarName(value)
        }
    }
})
