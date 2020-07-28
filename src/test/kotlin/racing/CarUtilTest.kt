package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racing.util.CarUtil

internal class CarUtilTest {

    @Test
    fun `자동차 수가 null이거나 비어있는 경우 validate시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarUtil.validate("", "3")
        }.withMessage(CarUtil.DATA_IS_BLANK)
    }

    @Test
    fun `문자가 입력된 경우 validate시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarUtil.validate("1", "A")
        }.withMessage(CarUtil.IS_POSSIBLE_NUMERIC)
    }

    @Test
    fun `자동차 이름이 5자를 초과하는 경우 validate 시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarUtil.validate("k3, sonata", "5")
        }.withMessage(CarUtil.EXCEED_FIVE_CHARACTERS)
    }

    @Test
    fun `, , , 와 같은 자동차 이름이 입력된 경우, validate 시 exception 발생`() {
        assertThatIllegalArgumentException().isThrownBy {
            CarUtil.validate(" , , , ", "10")
        }.withMessage(CarUtil.DATA_FORMMAT_IS_BAD)
    }

    @Test
    fun `자동차 이름에 "k3, k5, , "와 같이 , 로 구분된 빈공백이 있는 경우, 2개의 name만 인정되는지 확인`() {
        assertThat(CarUtil.splitNames("k3, k5,  , ").size).isEqualTo(2)
    }
}
