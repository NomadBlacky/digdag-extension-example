package dev.nomadblacky.digdag_extension_example
import java.util

import com.google.common.collect.ImmutableList
import com.google.inject.name.Names
import com.google.inject.{Binder, Module}
import io.digdag.spi.{Extension, Notification, NotificationSender}
import org.slf4j.LoggerFactory

class ExampleExtension extends Extension {
  override def getModules: util.List[Module] = ImmutableList.of(ExampleModule)
}

object ExampleModule extends Module {
  override def configure(binder: Binder): Unit =
    binder
      .bind(classOf[NotificationSender])
      .annotatedWith(Names.named("example"))
      .to(classOf[ExampleNotificationSender])
}

class ExampleNotificationSender extends NotificationSender {
  private val logger = LoggerFactory.getLogger(classOf[ExampleNotificationSender])

  override def sendNotification(notification: Notification): Unit = {
    logger.info("========== ExampleNotificationSender ==========")
    logger.info(notification.toString)
    logger.info("===============================================")
  }
}
