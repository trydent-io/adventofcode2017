package io.trydent.aoc2017

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.TestInstance
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import java.lang.Integer.parseInt
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

fun day1(first: Char, advent: String, acc: Int, last: Char = ' '): Int = when {
  advent.isEmpty() && last == first -> acc + parseInt(first.toString())
  advent.isEmpty() && last != first -> acc
  first == advent[0] -> day1(advent[0], if (advent.isEmpty()) "" else advent.substring(1), acc + parseInt(first.toString()), last)
  first != advent[0] -> day1(advent[0], if (advent.isEmpty()) "" else advent.substring(1), acc, last)
  else -> acc
}

@TestInstance(PER_CLASS)
@RunWith(JUnitPlatform::class)
class Day1Test {

  @Test
  fun `first case`() {
    val case = "1122"

    assertThat(day1(case[0], case.substring(1), 0)).isEqualTo(3)
  }

  @Test
  fun `second case`() {
    val case = "1111"

    assertThat(day1(case[0], case.substring(1), 0, case[0])).isEqualTo(4)
  }

  @Test
  fun `third case`() {
    val case = "1234"

    assertThat(day1(case[0], case.substring(1), 0, case[0])).isEqualTo(0)
  }

  @Test
  fun `forth case`() {
    val case = "91212129"

    assertThat(day1(case[0], case.substring(1), 0, case[0])).isEqualTo(9)
  }

  @Test
  fun `fifth case`() {
    val case = Files.readAllLines(Paths.get(Day1Test::class.java.classLoader.getResource("day1.txt").toURI()))[0]

    assertThat(day1(case[0], case.substring(1), 0, case[0])).isEqualTo(1034)
  }
}
