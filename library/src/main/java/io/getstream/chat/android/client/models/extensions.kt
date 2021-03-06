package io.getstream.chat.android.client.models

internal const val EXTRA_IMAGE = "image"
internal const val EXTRA_NAME = "name"

fun Channel.getUnreadMessagesCount(): Int {
    return read.sumBy {
        it.unreadMessages
    }
}

var User.image: String
    get() = getExternalField(this, EXTRA_IMAGE)
    set(value) {
        extraData[EXTRA_IMAGE] = value
    }

var User.name: String
    get() = getExternalField(this, EXTRA_NAME)
    set(value) {
        extraData[EXTRA_NAME] = value
    }

var Channel.image: String
    get() = getExternalField(this, EXTRA_IMAGE)
    set(value) {
        extraData[EXTRA_IMAGE] = value
    }

var Channel.name: String
    get() = getExternalField(this, EXTRA_NAME)
    set(value) {
        extraData[EXTRA_NAME] = value
    }

internal fun getExternalField(obj: CustomObject, key: String): String {

    val value = obj.extraData[key]
    val emptyResult = ""

    return if (value == null) {
        emptyResult
    } else {
        if (value is String) {
            value
        } else {
            emptyResult
        }
    }
}