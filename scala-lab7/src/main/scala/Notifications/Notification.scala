package Notifications

sealed abstract class Notification

case class SMS(caller: String, message: String) extends Notification
case class VoiceRecording(contactName: String, link: String) extends Notification
case class Email(sender: String, title: String, body: String) extends Notification
