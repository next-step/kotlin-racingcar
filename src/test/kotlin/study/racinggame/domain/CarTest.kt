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
        val participant = Participant("1st")
        val car = Car(participant, NormalEngine(), Position())

        // when
        val currentPosition: CarPosition = car.move()

        // then
        currentPosition.participant shouldBe participant
        currentPosition.position shouldBe Position(2)
    }

    "자동차 엔진이 움직이는데 실패하면 자동차의 위치가 변경 되지 않는다." {
        // given
        val participant = Participant("2st")
        val car = Car(participant, BrokenEngine(), Position())

        // when
        val currentPosition: CarPosition = car.move()

        // then
        currentPosition.participant shouldBe participant
        currentPosition.position shouldBe Position(1)
    }
})
