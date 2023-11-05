package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarNameTest {

    @Test
    @DisplayName("CarName을 정상적으로 생성한다.")
    fun createCarName() {
        val carName = CarName("Bear1")

        assertThat(carName.name).isEqualTo("Bear1")
    }

    @Test
    @DisplayName("이름의 크기가 5자보다 크면 오류를 반환한다.")
    fun validateNameSize() {
        assertThrows(IllegalArgumentException::class.java) {
            CarName("Bear12")
        }
    }

    @Test
    @DisplayName("이름이 공백이면 오류를 반환한다,")
    fun validateIsBlank() {
        assertThrows(IllegalArgumentException::class.java) {
            CarName("  ")
        }
    }
}
