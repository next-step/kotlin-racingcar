package racinggame.domain.player

import java.math.BigInteger

@JvmInline
value class UserUniqueId private constructor(val value: BigInteger) {

    companion object {

        private var version = BigInteger.valueOf(0)

        fun create(): UserUniqueId {
            return UserUniqueId(version++)
        }
    }
}
