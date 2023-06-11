package study.racinggame.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

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

    "자동차 엔진이 움직이는데 성공하면 자동차의 위치가 변경 된다." {
        // given
        val car = Car(NormalEngine())

        // when
        val currentPosition = car.move()

        // then
        currentPosition shouldBe 2
    }

    "자동차 엔진이 움직이는데 실패하면 자동차의 위치가 변경 되지 않는다." {
        // given
        val car = Car(BrokenEngine())

        // when
        val currentPosition = car.move()

        // then
        currentPosition shouldBe 1
    }
})
