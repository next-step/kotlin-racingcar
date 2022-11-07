package step2.user

class UserInput private constructor(
    val value: List<String>
) {

    companion object {
        fun from(input: String): UserInput {
            validate(input)

            return UserInput(
                input.split(" ").filter { it.isNotBlank() }
            )
        }

        private fun validate(input: String) {
            if (input.isBlank()) throw IllegalArgumentException("입력값은 공백일 수 없습니다.")
        }
    }
}
