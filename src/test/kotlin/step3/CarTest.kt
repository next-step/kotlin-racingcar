package step3

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest() {
    @Test
    fun `car 생성 확인`() {
        val car = Car.build()
        car.positionValue shouldBe 1
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4이상이 나오면 전진`(givenNumber: Int) {
        RaceRule.isGo(RaceNumber.from(givenNumber)) shouldBe true
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4미만 나오면 전진 안함`(givenNumber: Int) {
        RaceRule.isGo(RaceNumber.from(givenNumber)) shouldBe false
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `car의 progress 하는지 확인`(givenNumber: Int) {
        // given
        val car = Car.build()
        val raceNumber = RaceNumber.from(givenNumber)

        // when
        car.progress(raceNumber)

        // then
        car.positionValue shouldBe 2
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `car의 progress 안 하는지 확인`(givenNumber: Int) {
        // given
        val car = Car.build()
        val raceNumber = RaceNumber.from(givenNumber)

        // when
        car.progress(raceNumber)

        // then
        car.positionValue shouldBe 1
    }
}
