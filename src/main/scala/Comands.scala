package net.davidwiles.commands

import java.io.File
import java.nio.file.Paths
import scala.util.{Failure, Success, Try}

/**
 * Each command or subcommand should extend Command. This trait only requires that
 * execute() is defined, which should be called by the main class whenever the command
 * should be run. All business logic for the command should be done here.
 */
trait Command {
  def execute(): Unit
}

/**
 * The companion object for each Command should extend CommandParser. This object will
 * be responsible for parsing command line arguments and validating input.
 */
trait CommandParser {
  // The string to print describing the command, its options, and its arguments
  val usage: String

  // The name of the command as used by the CLI
  val commandName: String

  /**
   * parse should parse the arguments for this specific command and return either some
   * Command or None. Each sub-command should be called with the tail of the arguments
   * passed to this parse function
   *
   * @param args the command line arguments
   * @return any valid command parsed by these arguments
   */
  def parse(args: List[String]): Option[Command]

  /**
   * parse should parse the arguments for this specific command and return either some
   * Command or None. Each sub-command should be called with the tail of the arguments
   * passed to this parse function, so any persistent arguments should be given in the
   * persistentArgs parameter
   *
   * @param args           the command line arguments
   * @param persistentArgs any persistent arguments that have already been parsed
   * @return any valid command parsed by these arguments
   */
  def parse(args: List[String], persistentArgs: Map[String, Any]): Option[Command]

  /**
   * printUsage should be used to print the usage for a command and exit. This is
   * helpful whenever invalid flags or arguments are passed.
   *
   * @return Always returns None to satisfy the Option[Command] return type of parse()
   */
  def printUsage(): Option[Command] = {
    println(usage)
    None
  }

  /**
   * Allows for printing an optional error message before the rest of the command's usage.
   *
   * @param msg Error text
   * @return Always returns None to satisfy the Option[Command] return type of parse()
   */
  def printUsage(msg: String): Option[Command] = {
    println(msg)
    printUsage()
  }

  /**
   * Convenience method to use from a main function to parse and execute a command
   *
   * @param args The full command-line arguments from main
   */
  final def start(args: List[String]): Unit = parse(args).foreach(_.execute())
}


