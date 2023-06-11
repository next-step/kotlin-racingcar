package study.racinggame.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class BrokenEngine : CarEngine {
    override fun run(): Int {
        return 0
    }
}

class NormalEngine : CarEngine {
    override fun run(): Int {
        return 1
    }
}

class CarTest : StringSpec({

    "자동차 이름이 빈 문자열이면 생성 시 오류가 발생 한다." {
        // given
        val name = ""

        // when & then
        shouldThrow<IllegalArgumentException> { Car(name, NormalEngine()) }
    }

    "자동차 이름이 공백 문자열이면 생성 시 오류가 발생 한다." {
        // given
        val name = "  "

        // when & then
        shouldThrow<IllegalArgumentException> { Car(name, NormalEngine()) }
    }

    "자동차 이름이 5글자를 초과하면 생성 시 오류가 발생 한다." {
        // given
        val name = ""

        // when & then
        shouldThrow<IllegalArgumentException> { Car(name, NormalEngine()) }
    }

    "자동차 엔진이 움직이는데 성공하면 자동차의 위치가 변경 된다." {
        // given
        val car = Car("1st", NormalEngine())

        // when
        val currentPosition = car.move()

        // then
        currentPosition.name shouldBe "1st"
        currentPosition.position shouldBe 2
    }

    "자동차 엔진이 움직이는데 실패하면 자동차의 위치가 변경 되지 않는다." {
        // given
        val car = Car("2nd", BrokenEngine())

        // when
        val currentPosition = car.move()

        // then
        currentPosition.name shouldBe "2nd"
        currentPosition.position shouldBe 1
    }
})
