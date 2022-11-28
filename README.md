# Commands

This is a very basic package to use as as base for a CLI. It includes definitions for commands and parsers as well
as utilities to help parsing flags and subcommands. Commands and flags should still be parsed by the program itself.

## Usage

Add this line to your `build.sbt` file:

```
"net.davidwiles" %% "commands" % "0.1.0"
```

Create a class for your command and its companion object:

```
class MyCommand extends Command ...

object MyCommand extends CommandParser ...
```

Apply the command line arguments to `start`. This will call `parse` and `execute`

```
MyCommand.start(args)
```

See `Commands.scala` for more details