package com.laczkoattilalaszlo.stub

import com.laczkoattilalaszlo.stub.hierachicalstub.Contact
import com.laczkoattilalaszlo.stub.hierachicalstub.ContactProvider
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class HierarchicalStubTests {

	@Test
	fun `test without hierarchical stub`() {
		val contact: Contact = mockk<Contact> {
			every { name } returns "Attila"
			every { address.zip } returns "1111"
			every { address.city } returns "Budapest"
		}
		val contactProvider: ContactProvider = ContactProvider(contact = contact)

		contactProvider.provideContact() shouldBe "name: Attila, address: 1111 Budapest"

	}

	@Test
	fun `test with hierarchical stub`() {
		val contact: Contact = mockk<Contact> {
			every { name } returns "Attila"
			every { address } returns mockk {
				every { zip } returns "1111"
				every { city } returns "Budapest"
			}
		}
		val contactProvider: ContactProvider = ContactProvider(contact = contact)

		contactProvider.provideContact() shouldBe "name: Attila, address: 1111 Budapest"
	}
}
