package com.laczkoattilalaszlo.stub

import com.laczkoattilalaszlo.stub.service.Concatenator
import com.laczkoattilalaszlo.stub.service.NumberProvider
import com.laczkoattilalaszlo.stub.service.TextProvider
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class StubApplicationTests {

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

}
