package com.laczkoattilalaszlo.stub.hierachicalstub

class ContactProvider(
    private val contact: Contact
) {

    fun provideContact(): String {
        return "name: ${contact.name}, address: ${contact.address.zip} ${contact.address.city}"
    }
}