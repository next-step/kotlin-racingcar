package racingcar.input

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.input.value.NumberOfCars
import racingcar.input.value.PlayTime

class InputResultDtoTest {
    @DisplayName("getter 테스트")
    @Test
    fun `getNumberOfCars() 테스트`() {
        val numberOfCars = NumberOfCars(3)
        val playTime = PlayTime(5)
        val inputResultDto = InputResultDto(numberOfCars, playTime)

        assertThat(inputResultDto.getNumberOfCars()).isEqualTo(3)
        assertThat(inputResultDto.getPlayTime()).isEqualTo(5)
    }
}
