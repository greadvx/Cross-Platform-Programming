package Notifications


object Notifications extends App {

  def notificationsText(notification: Notification): String = {
    notification match {
      case Email(sender, title, body) => "Email from: "+ sender +
                                          ". Title: " + title +
                                          ". Text: " + body
      case SMS(caller, message) => "SMS from: " + caller +
                                    ". Text: " + message
      case VoiceRecording(contactName, link) => "Voice message from: " + contactName +
                                                ". Link: " + link
      case _ => "not a notification"
    }
  }
}
