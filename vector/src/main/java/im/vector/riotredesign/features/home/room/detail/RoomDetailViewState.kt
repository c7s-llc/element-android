/*
 * Copyright 2019 New Vector Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.vector.riotredesign.features.home.room.detail

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import im.vector.matrix.android.api.session.room.model.RoomSummary
import im.vector.matrix.android.api.session.room.timeline.Timeline
import im.vector.matrix.android.api.session.room.timeline.TimelineData
import im.vector.matrix.android.api.session.room.timeline.TimelineEvent
import im.vector.matrix.android.api.session.user.model.User

/**
 * Describes the current send mode:
 * REGULAR: sends the text as a regular message
 * QUOTE: User is currently quoting a message
 * EDIT: User is currently editing an existing message
 *
 * Depending on the state the bottom toolbar will change (icons/preview/actions...)
 */
enum class SendMode {
    REGULAR,
    QUOTE,
    EDIT,
    REPLY
}

data class RoomDetailViewState(
        val roomId: String,
        val eventId: String?,
        val timeline: Timeline? = null,
        val asyncInviter: Async<User> = Uninitialized,
        val asyncRoomSummary: Async<RoomSummary> = Uninitialized,
        val asyncTimelineData: Async<TimelineData> = Uninitialized,
        val sendMode: SendMode = SendMode.REGULAR,
        val selectedEvent: TimelineEvent? = null
) : MvRxState {

    constructor(args: RoomDetailArgs) : this(roomId = args.roomId, eventId = args.eventId)

}