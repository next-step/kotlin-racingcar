package racingcar.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.domain.carracer.MockCarRacer

internal class RacingCarTest : AnnotationSpec() {

    @ParameterizedTest
    @CsvSource(value = ["0,0", "3,0", "4,1", "9,1"])
    fun `레이싱 카는 이동 요청 시, 4 이상일 경우에만 이동해야 한다`(accepted: Int, expected: Int) {
        // given
        val racingCar = RacingCar(MockCarRacer(accepted))

        // when
        racingCar.move()

        // then
        racingCar.movement shouldBe expected
    }

    @Test
    fun `자동차에 이름을 부여할 수 있다`() {
        // given
        val name = "자동차이름"

        // when
        val racingCar = RacingCar(RacingCarName(name), MockCarRacer(0))

        // then
        racingCar.name shouldBe name
    }
}
