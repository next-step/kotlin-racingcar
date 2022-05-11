package study.car

import car.domain.Position
import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PositionTest : StringSpec({
    "Position 객체 정상 생성" {
        shouldNotThrow<Throwable> { Position() }
    }

    "Position 생성 시 위치는 0으로 설정된다." {
        Position().value shouldBe 0
    }

    "Position 값이 음수이면 Exception을 반환한다." {
        shouldThrow<IllegalArgumentException> { Position(-1) }
    }

    "Position 값을 증가시킬수 있다." {
        val initPosition = Position()
        val increasedPosition = initPosition.increase()

        initPosition.value shouldBe 0
        increasedPosition.value shouldBe 1
    }
})
