package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.io.Source

// This controller returns buki information
@Singleton
class BukiController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def buki(buki_id: String) = Action { implicit request: Request[AnyContent] =>
    val bukiData = new Buki(buki_id)
    Ok(views.html.buki(bukiData))
  }
}
