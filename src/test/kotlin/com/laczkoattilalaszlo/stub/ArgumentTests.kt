package com.laczkoattilalaszlo.stub

import com.laczkoattilalaszlo.stub.argument.Divider
import io.kotest.matchers.shouldBe
import io.mockk.CapturingSlot
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ArgumentTests {

	@Test
	fun `test with any() argument matcher`() {
		val divider: Divider = mockk<Divider>()

		every { divider.divide(any(), any()) } returns 123

		divider.divide(1, 2) shouldBe 123
	}

	@Test
	fun `test with argument capturing`() {
		val divider: Divider = mockk<Divider>()
		val number1: CapturingSlot<Int> = slot<Int>()					// Capture one value.

		every { divider.divide(capture(number1), any()) } returns 123

		divider.divide(1, 2) shouldBe 123
		number1.captured shouldBe 1										// Access the captured value.
	}
}
