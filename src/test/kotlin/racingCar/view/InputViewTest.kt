package racingCar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.constants.Message
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method

/**
 * input에 대한 테스트
 * Created by Jaesungchi on 2022.05.07..
 */
class InputViewTest {
    private val methodChangeStringToInt: Method =
        InputView::class.java.getDeclaredMethod("changeStringToInt", String::class.java).apply {
            isAccessible = true
        }

    @Test
    fun `0이 입력되었을 때 에러발생`() {
        try {
            methodChangeStringToInt.invoke(InputView, "0")
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
        }
    }

    @Test
    fun `음수가 입력되었을 때 에러발생`() {
        try {
            methodChangeStringToInt.invoke(InputView, "-1")
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(Message.ExceptionMessage.ENTERED_INVALID_NUMBER)
        }
    }

    @Test
    fun `글자가 입력되었을 때 에러발생`() {
        try {
            methodChangeStringToInt.invoke(InputView, "글자")
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(Message.ExceptionMessage.IS_NOT_INTEGER)
        }
    }

    @Test
    fun `null이 입력되었을 때 에러발생`() {
        try {
            methodChangeStringToInt.invoke(InputView, null)
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        }
    }

    @Test
    fun `빈칸이 입력되었을 때 에러발생`() {
        try {
            methodChangeStringToInt.invoke(InputView, " ")
        } catch (e: InvocationTargetException) {
            assertThat(e.cause?.message).isEqualTo(Message.ExceptionMessage.IS_NULL_OR_BLANK)
        }
    }
}
