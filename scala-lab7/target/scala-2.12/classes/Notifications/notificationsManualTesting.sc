import Notifications._

Notifications.notificationsText(SMS("aaa", "ccc"))
Notifications.notificationsText(Email("aaa", "bb", "ccc"))
Notifications.notificationsText(VoiceRecording("aaa", "zzz"))