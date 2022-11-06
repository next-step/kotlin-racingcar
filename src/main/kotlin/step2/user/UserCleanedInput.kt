package step2.user

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

data class UserCleanedInput(
    val inputList: List<String>
) {

    companion object {
        @JvmStatic
        fun from(input: String?): UserCleanedInput {
            validate(input)
            return UserCleanedInput(
                input.split(" ").filter { it.isNotBlank() }
            )
        }

        @OptIn(ExperimentalContracts::class)
        private fun validate(input: String?) {
            contract {
                returns() implies (input != null)
            }
            if (input == null) throw IllegalArgumentException("입력값은 null 일 수 없습니다.")
            if (input.trim().isBlank()) throw IllegalArgumentException("입력값은 공백일 수 없습니다.")
        }
    }
}
