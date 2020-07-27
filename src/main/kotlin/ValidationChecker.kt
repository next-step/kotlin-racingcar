import java.lang.IllegalArgumentException

object ValidationChecker {
    /*.
        기존에 validationChecker에 있던 다른 함수를 StringCalculator.kt로 옮기면서
        불필요한 코드는 제거했습니다.
        아래의 checkUserInputIsBlankOrEmpty 함수가 하나 남아있는데 이것도 옮기는게 좋을까요??
     */
    fun checkUserInputIsBlankOrEmpty(userInput: String) {
        if (userInput.equals("") || userInput.equals(" ")) {
            throw IllegalArgumentException("공백 또는 빈 문자열을 입력하셨습니다.")
        }
    }
}
