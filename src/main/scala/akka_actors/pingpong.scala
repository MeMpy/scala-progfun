package akka_actors

/**
  * Created by Ross on 7/2/2016.
  */

/**
  * Actor is a framework to provide multithreaded programming
  * both sync and async
  * The features of the akka framework are:
  * - Actor class that extended provides messages functionality
  * - An Actor is a class in which methods can send messages.
  * - Various util methods that allow you to send message to other actors
  */

//import akka.actor.Actor
//
//case object Ping
//case object Pong
//
//class Ping(pong:Actor) extends Actor {
//  def act(){
//    pong ! Ping
//  }
//}
//
//class Pong extends Actor {
//
//  override def receive() {
//      case x:Ping => Console.println("ping")
//    }
//}
//
//object pingpong extends App{
//  val pong = new Pong
//  val ping = new Ping(pong)
//  ping.start
//  pong.start
//}
