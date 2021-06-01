// Code generated by Wire protocol buffer compiler, do not edit.
// Source: squareup.protos.kotlin.redacted_test.RedactedRepeated in redacted_test.proto
package com.squareup.wire.protos.kotlin.redacted

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.immutableCopyOf
import com.squareup.wire.`internal`.redactElements
import kotlin.Any
import kotlin.AssertionError
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.DeprecationLevel
import kotlin.Int
import kotlin.Long
import kotlin.Nothing
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.jvm.JvmField
import okio.ByteString

public class RedactedRepeated(
  a: List<String> = emptyList(),
  b: List<RedactedFields> = emptyList(),
  unknownFields: ByteString = ByteString.EMPTY
) : Message<RedactedRepeated, Nothing>(ADAPTER, unknownFields) {
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING",
    label = WireField.Label.REPEATED,
    redacted = true
  )
  public val a: List<String> = immutableCopyOf("a", a)

  /**
   * Values in the repeated type need redacting.
   */
  @field:WireField(
    tag = 2,
    adapter = "com.squareup.wire.protos.kotlin.redacted.RedactedFields#ADAPTER",
    label = WireField.Label.REPEATED
  )
  public val b: List<RedactedFields> = immutableCopyOf("b", b)

  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is RedactedRepeated) return false
    if (unknownFields != other.unknownFields) return false
    if (a != other.a) return false
    if (b != other.b) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + a.hashCode()
      result = result * 37 + b.hashCode()
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (a.isNotEmpty()) result += """a=██"""
    if (b.isNotEmpty()) result += """b=$b"""
    return result.joinToString(prefix = "RedactedRepeated{", separator = ", ", postfix = "}")
  }

  public fun copy(
    a: List<String> = this.a,
    b: List<RedactedFields> = this.b,
    unknownFields: ByteString = this.unknownFields
  ): RedactedRepeated = RedactedRepeated(a, b, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<RedactedRepeated> = object : ProtoAdapter<RedactedRepeated>(
      FieldEncoding.LENGTH_DELIMITED, 
      RedactedRepeated::class, 
      "type.googleapis.com/squareup.protos.kotlin.redacted_test.RedactedRepeated", 
      PROTO_2, 
      null
    ) {
      public override fun encodedSize(`value`: RedactedRepeated): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, value.a)
        size += RedactedFields.ADAPTER.asRepeated().encodedSizeWithTag(2, value.b)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: RedactedRepeated): Unit {
        ProtoAdapter.STRING.asRepeated().encodeWithTag(writer, 1, value.a)
        RedactedFields.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.b)
        writer.writeBytes(value.unknownFields)
      }

      public override fun decode(reader: ProtoReader): RedactedRepeated {
        val a = mutableListOf<String>()
        val b = mutableListOf<RedactedFields>()
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> a.add(ProtoAdapter.STRING.decode(reader))
            2 -> b.add(RedactedFields.ADAPTER.decode(reader))
            else -> reader.readUnknownField(tag)
          }
        }
        return RedactedRepeated(
          a = a,
          b = b,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: RedactedRepeated): RedactedRepeated = value.copy(
        a = emptyList(),
        b = value.b.redactElements(RedactedFields.ADAPTER),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
