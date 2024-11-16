package race

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CarsTest {
//    @Test
//    fun `moveAll은 주어진 이동 조건에 따라 움직인다`() {
//        val cars = Cars(Names("a,b"))
//        val moveConditions =
//            MoveConditions(
//                listOf(
//                    MoveCondition(PositiveNumber(4)),
//                    MoveCondition(PositiveNumber(3)),
//                ),
//            )
//
//        cars.moveAll(moveConditions)
//
//        val expected = listOf(Car("a", 2), Car("b", 1))
//        cars.forEachIndexed { index, car ->
//            assertThat(car).isEqualTo(expected[index])
//        }
//    }

//    @Test
//    fun `moveCondition 갯수가 다르면 예외를 던진다`() {
//        val cars = Cars(Names("a,b,c,d"))
//        val moveConditions =
//            MoveConditions(
//                listOf(
//                    MoveCondition(PositiveNumber(1)),
//                    MoveCondition(PositiveNumber(1)),
//                    MoveCondition(PositiveNumber(1)),
//                ),
//            )
//
//        assertThatIllegalArgumentException().isThrownBy {
//            cars.moveAll(moveConditions)
//        }
//    }

    @Test
    fun `Cars는 최소 1대 이상 입력해야 한다`() {
        assertThatIllegalArgumentException().isThrownBy {
            Cars(Names(""))
        }
    }
}
