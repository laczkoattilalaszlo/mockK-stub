package com.laczkoattilalaszlo.stub

import com.laczkoattilalaszlo.stub.stub.Concatenator
import com.laczkoattilalaszlo.stub.stub.NumberProvider
import com.laczkoattilalaszlo.stub.stub.TextProvider
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StubTests {

	@Test
	fun `test without stub`() {
		val numberProvider: NumberProvider = NumberProvider()
		val textProvider: TextProvider = TextProvider()
		val concatenator: Concatenator = Concatenator(textProvider = textProvider, numberProvider = numberProvider)

		concatenator.concatenate() shouldBe "asd123"
	}

	@Test
	fun `test with stub`() {
		val numberProvider: NumberProvider = mockk<NumberProvider>()
		val textProvider: TextProvider = mockk<TextProvider>()
		val concatenator: Concatenator = Concatenator(textProvider = textProvider, numberProvider = numberProvider)

		every { numberProvider.provideNumber() } returns 456
		every { textProvider.provideText() } returns "qwe"

		concatenator.concatenate() shouldBe "qwe456"
	}

	@Test
	fun `test with stub and behaviour verification`() {
		val numberProvider: NumberProvider = mockk<NumberProvider>()
		val textProvider: TextProvider = mockk<TextProvider>()
		val concatenator: Concatenator = Concatenator(textProvider = textProvider, numberProvider = numberProvider)

		every { numberProvider.provideNumber() } returns 456
		every { textProvider.provideText() } returns "qwe"

		concatenator.concatenate() shouldBe "qwe456"	// Checking System Under Test.

		verify {										// Behavior verification: Checks that mocked Dependent-On Components
			numberProvider.provideNumber()				// were called. This checks should be placed at the end of the test,
			textProvider.provideText()					// after checking System Under Test.
		}
	}

}
