package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class RandomMoveTest : StringSpec({

    "랜덤 숫자의 최소값이 최대값보다 크면 예외가 발생한다" {
        shouldThrow<IllegalArgumentException> {
            RandomMove(10, 9)
        }
    }

    "랜덤 값이 이동 조건 값보다 크거나 같으면 true를 반환한다" {
        val randomMove = RandomMove(5, 9, 4)

        randomMove.canMoveIt() shouldBe true
    }

    "랜덤 값이 이동 조건 값보다 작으면 false를 반환한다" {
        val randomMove = RandomMove(5, 9, 10)

        randomMove.canMoveIt() shouldBe false
    }
})
