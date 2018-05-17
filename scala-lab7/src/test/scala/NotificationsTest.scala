import Notifications._
import org.scalatest.FunSuite

class NotificationsTest extends FunSuite {

  test("SMS notification") {
    assert(Notifications.notificationsText(SMS("Yan Khamutouski","Hello world")) ===
                                      "SMS from: Yan Khamutouski. Text: Hello world")
  }
  test ("Email notification") {
    assert(Notifications.notificationsText(
      Email("Yan Khamutouski", "Course work", "Alex, my iOS app is ready!"))
      === "Email from: Yan Khamutouski. Title: Course work. Text: Alex, my iOS app is ready!")
  }
  test("Voice message notification") {
    assert(Notifications.notificationsText(VoiceRecording("Yan Khamutouski", "goo.gl/SKZq8w"))
      === "Voice message from: Yan Khamutouski. Link: goo.gl/SKZq8w")
  }
}
