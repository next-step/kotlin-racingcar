package racingcar.userInput

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class UserNameInfoTest {

    @Test
    @DisplayName("유저 이름을 입력받가 문자열 리스트로 파싱한다.")
    fun getUsernames() {
        val userNameInfo = UserNameInfo("pobi,crong, honux")
        assertThat(userNameInfo.usernames).containsSequence("pobi", "crong", "honux")
    }
}
