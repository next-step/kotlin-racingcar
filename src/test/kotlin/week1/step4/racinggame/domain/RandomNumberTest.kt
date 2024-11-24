package week1.step4.racinggame.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class RandomNumberTest : StringSpec({
    "Car는 0~9 이외의 값을 받으면 InvalidArgumentException 예외를 던진다" {
        listOf(-1, 10).forEach { randomNumber ->
            shouldThrow<IllegalArgumentException> {
                RandomNumber(randomNumber)
            }
        }
    }
})
