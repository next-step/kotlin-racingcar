package study

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CollectionTest {
    @Test
    fun arrayList() {
        val values = ArrayList<String>()
        values.add("first")
        values.add("second")
        Assertions.assertThat(values.add("third")).isTrue
        Assertions.assertThat(values.size).isEqualTo(3)
        Assertions.assertThat(values[0]).isEqualTo("first")
        Assertions.assertThat(values.contains("first")).isTrue
        Assertions.assertThat(values.removeAt(0)).isEqualTo("first")
        Assertions.assertThat(values.size).isEqualTo(2)
    }
}
