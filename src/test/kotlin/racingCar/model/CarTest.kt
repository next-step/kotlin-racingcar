package racingCar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.constants.Message

/**
 * Car 클래스 테스트 클래스
 * Created by Jaesungchi on 2022.05.12..
 */
class CarTest {

    @Test
    fun `차량 이름이 5글자가 넘어갈 경우`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car("abcdefg")
        }.withMessageMatching(Message.ExceptionMessage.CANNOT_NAME_EXCEED_5_CHARACTERS)
    }

    @Test
    fun `차량 이름이 빈칸인 경우`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Car(" ")
        }.withMessageMatching(Message.ExceptionMessage.CANNOT_NAME_BE_BLANK)
    }
}