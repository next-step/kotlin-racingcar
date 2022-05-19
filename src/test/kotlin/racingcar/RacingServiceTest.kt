package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import racingcar.application.RacingService
import racingcar.domain.Car
import racingcar.domain.Cars
import racingcar.domain.MoveStrategy

internal class RacingServiceTest {

    @Test
    fun `레이싱 컬렉션 사이즈`() {
        val strategy = MoveStrategy { true }
        val racing = RacingService(strategy)

        val response = racing.start(1, Cars(listOf(Car("a"), Car("b"))))
        assertThat(response.allResult).size().isEqualTo(1)
    }

    @Test
    fun `결과 값 테스트`() {

        val strategy = MoveStrategy { true }
        val racing = RacingService(strategy)

        val response = racing.start(1, Cars(listOf(Car("a"), Car("b"))))

        assertAll("자동차 포지션 테스트", {
            assertThat(response.allResult[0].cars[0].position).isEqualTo(1)
            assertThat(response.allResult[0].cars[1].position).isEqualTo(1)
        })
    }

    @Test
    fun `잘못된 결과 값 테스트`() {

        val strategy = MoveStrategy { true }
        val racing = RacingService(strategy)

        val response = racing.start(1, Cars(listOf(Car("a"), Car("b"))))
        assertThrows<IndexOutOfBoundsException> { response.allResult[1].cars[0].position }
    }
}
