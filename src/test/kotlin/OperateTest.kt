import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OperateTest {
    @Test
    @DisplayName("연산자 찾기")
    fun findOperate() {
        val plus = Operate.generate("+")
        assert(plus == Operate.PLUS)
        val minus = Operate.generate("-")
        assert(minus == Operate.MINUS)
    }

    @Test
    @DisplayName("존재하지 않는 연산자 찾기")
    fun notFoundOperate() {
        assertThrows<NoSuchElementException> {
            Operate.generate("none")
        }
    }

    @Test
    @DisplayName("계산 함수 테스트")
    fun calcMethod() {
        val sum = Operate.PLUS.calc(10.0, 5.0)
        assert(sum == 15.0)

        val multi = Operate.MULTI.calc(0.0, 20.0)
        assert(multi == 0.0)

        val div = Operate.DIVISION.calc(10.0, 5.0)
        assert(div == 2.0)

        assertThrows<IllegalArgumentException> {
            Operate.DIVISION.calc(10.0, 0.0)
        }
    }
}
