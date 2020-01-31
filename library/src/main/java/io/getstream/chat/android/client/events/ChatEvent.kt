package io.getstream.chat.android.client.events

import com.google.gson.annotations.SerializedName
import io.getstream.chat.android.client.EventType
import io.getstream.chat.android.client.utils.UndefinedDate
import java.util.*


open class ChatEvent {

    lateinit var type: String

    @SerializedName("created_at")
    val createdAt: Date = UndefinedDate

    var receivedAt: Date = Date()

    fun getType(): EventType {
        return EventType.values().firstOrNull {
            it.label == type
        } ?: EventType.UNKNOWN
    }
}