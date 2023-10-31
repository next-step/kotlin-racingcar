package study.racing.process

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RacingTest {

    @ParameterizedTest
    @ValueSource(
        strings = [
            "aasdf", "a,bbbbbbbb", ",33f", "afsf,55555", " , ", "  a  1 , b    5 "
        ]
    )
    fun `자동차 이름이 4글자이하가 아니거나 공백인 경우 에러를 반환한다`(
        carNames: String
    ) {
        assertThrows<IllegalArgumentException> {
            val racing = Racing()
            racing.playRacing(carNames, 1)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -11, -111])
    fun `라운드수 입력시 1이상의 정수가 아닌 경우 에러를 반환한다`(
        roundCount: Int
    ) {
        assertThrows<IllegalArgumentException> {
            val racing = Racing()
            racing.playRacing("a,b,c,d", roundCount)
        }
    }

    @Test
    fun `레이싱 게임 실행시 매라운드 진행상황을 알 수 있다`() {
        // Given
        val carNames = "a,b,c,d"
        val roundCount = 2
        val racing = Racing()

        // When
        val actual = racing.playRacing(carNames, roundCount)

        // Then
        assertThat(actual.size).isEqualTo(roundCount)
    }

    @Test
    fun `레이싱 매 라운드별 결과를 정상적으로 복사 되었다면 각각 다른 해쉬값을 가진다`() {
        // Given
        val carNames = "a,b,c,d"
        val roundCount = 2
        val racing = Racing()

        // When
        val actual = racing.playRacing(carNames, roundCount)

        // Then
        assertThat(actual.first().hashCode()).isNotEqualTo(actual.last().hashCode())
    }
}
