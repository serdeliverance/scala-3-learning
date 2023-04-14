package com.part2additions

object Enums:

  enum Permissions:
    case READ, WRITE, EXECUTE, NONE

    // add fields/methods
    def openDocument(): Unit =
      if this == READ then println("opening document...")
      else println("reading not allowed")

  // constructor args
  enum PermissionsWithBits(bits: Int):
    case READ extends PermissionsWithBits(4) // 100
    case WRITE extends PermissionsWithBits(2) // 010
    case EXECUTE extends PermissionsWithBits(1) // 001
    case NONE extends PermissionsWithBits(0) // 000

  // you can add a companion object to your enum if you like
  object PermissionsWithBits:
    def fromBits(bits: Int): PermissionsWithBits = // some dummy impl
      PermissionsWithBits.NONE

  def main(args: Array[String]): Unit =
    val somePermissions = Permissions.READ
    somePermissions.openDocument()

    // standard API
    val somePermissionsOrdinal = somePermissions.ordinal
    val allPermissions = PermissionsWithBits.values
    val readPermission = PermissionsWithBits.valueOf("READ")
