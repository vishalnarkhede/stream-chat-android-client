package io.getstream.chat.android.client.socket

import io.getstream.chat.android.client.events.ChatEvent
import io.getstream.chat.android.client.models.User
import io.getstream.chat.android.client.utils.observable.ChatObservable
import io.getstream.chat.android.client.utils.observable.EventsObservable

interface ChatSocket {
    fun connect(user: User)
    fun connectAnonymously()
    fun events(): EventsObservable
    fun addListener(listener: SocketListener)
    fun removeListener(listener: SocketListener)
    fun disconnect()
}