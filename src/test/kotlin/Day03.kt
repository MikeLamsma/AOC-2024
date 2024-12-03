import org.junit.jupiter.api.Test
import util.readInput
import kotlin.test.assertEquals

private fun task1(input: List<String>) =
    Regex("mul\\((\\d+),(\\d+)\\)")
        .findAll(input.joinToString(""))
        .sumOf { result ->
            result.destructured.toList().map(String::toInt).reduce(Int::times)
        }

private fun task2(input: List<String>): Int {
    var enabled = true
    return Regex("mul\\((\\d+),(\\d+)\\)|do\\(\\)|don't\\(\\)")
        .findAll(input.joinToString(""))
        .sumOf { result ->
            when {
                enabled && result.value.startsWith("mul") -> {
                    result.destructured.toList().map(String::toInt).reduce(Int::times)
                }
                result.value.startsWith("do(") -> {
                    enabled = true
                    0
                }
                else -> {
                    enabled = false
                    0
                }
            }
        }
}


class Day03 {
    @Test
    fun testTask1ExampleInput() {
        val expected = 161
        val input = readInput("day03example")
        val answer = task1(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask1Input() {
        val expected = 184576302
        val input = readInput("day03")
        val answer = task1(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask2ExampleInput() {
        val expected = 48
        val input = readInput("day03example2")
        val answer = task2(input)

        assertEquals(expected, answer)
    }

    @Test
    fun testTask2Input() {
        val expected = 118173507
        val input = readInput("day03")
        val answer = task2(input)

        assertEquals(expected, answer)
    }
}