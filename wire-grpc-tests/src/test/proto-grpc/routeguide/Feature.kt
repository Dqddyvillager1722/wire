// Code generated by Wire protocol buffer compiler, do not edit.
// Source: routeguide.Feature in routeguide/RouteGuideProto.proto
package routeguide

import com.squareup.wire.FieldEncoding
import com.squareup.wire.Message
import com.squareup.wire.ProtoAdapter
import com.squareup.wire.ProtoReader
import com.squareup.wire.ProtoWriter
import com.squareup.wire.Syntax.PROTO_2
import com.squareup.wire.WireField
import com.squareup.wire.`internal`.sanitize
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
import kotlin.jvm.JvmField
import okio.ByteString

/**
 * A feature names something at a given point.
 *
 * If a feature could not be named, the name is empty.
 */
public class Feature(
  /**
   * The name of the feature.
   */
  @field:WireField(
    tag = 1,
    adapter = "com.squareup.wire.ProtoAdapter#STRING"
  )
  public val name: String? = null,
  /**
   * The point where the feature is detected.
   */
  @field:WireField(
    tag = 2,
    adapter = "routeguide.Point#ADAPTER"
  )
  public val location: Point? = null,
  unknownFields: ByteString = ByteString.EMPTY
) : Message<Feature, Nothing>(ADAPTER, unknownFields) {
  @Deprecated(
    message = "Shouldn't be used in Kotlin",
    level = DeprecationLevel.HIDDEN
  )
  public override fun newBuilder(): Nothing = throw
      AssertionError("Builders are deprecated and only available in a javaInterop build; see https://square.github.io/wire/wire_compiler/#kotlin")

  public override fun equals(other: Any?): Boolean {
    if (other === this) return true
    if (other !is Feature) return false
    if (unknownFields != other.unknownFields) return false
    if (name != other.name) return false
    if (location != other.location) return false
    return true
  }

  public override fun hashCode(): Int {
    var result = super.hashCode
    if (result == 0) {
      result = unknownFields.hashCode()
      result = result * 37 + (name?.hashCode() ?: 0)
      result = result * 37 + (location?.hashCode() ?: 0)
      super.hashCode = result
    }
    return result
  }

  public override fun toString(): String {
    val result = mutableListOf<String>()
    if (name != null) result += """name=${sanitize(name)}"""
    if (location != null) result += """location=$location"""
    return result.joinToString(prefix = "Feature{", separator = ", ", postfix = "}")
  }

  public fun copy(
    name: String? = this.name,
    location: Point? = this.location,
    unknownFields: ByteString = this.unknownFields
  ): Feature = Feature(name, location, unknownFields)

  public companion object {
    @JvmField
    public val ADAPTER: ProtoAdapter<Feature> = object : ProtoAdapter<Feature>(
      FieldEncoding.LENGTH_DELIMITED, 
      Feature::class, 
      "type.googleapis.com/routeguide.Feature", 
      PROTO_2, 
      null
    ) {
      public override fun encodedSize(`value`: Feature): Int {
        var size = value.unknownFields.size
        size += ProtoAdapter.STRING.encodedSizeWithTag(1, value.name)
        size += Point.ADAPTER.encodedSizeWithTag(2, value.location)
        return size
      }

      public override fun encode(writer: ProtoWriter, `value`: Feature): Unit {
        ProtoAdapter.STRING.encodeWithTag(writer, 1, value.name)
        Point.ADAPTER.encodeWithTag(writer, 2, value.location)
        writer.writeBytes(value.unknownFields)
      }

      public override fun decode(reader: ProtoReader): Feature {
        var name: String? = null
        var location: Point? = null
        val unknownFields = reader.forEachTag { tag ->
          when (tag) {
            1 -> name = ProtoAdapter.STRING.decode(reader)
            2 -> location = Point.ADAPTER.decode(reader)
            else -> reader.readUnknownField(tag)
          }
        }
        return Feature(
          name = name,
          location = location,
          unknownFields = unknownFields
        )
      }

      public override fun redact(`value`: Feature): Feature = value.copy(
        location = value.location?.let(Point.ADAPTER::redact),
        unknownFields = ByteString.EMPTY
      )
    }

    private const val serialVersionUID: Long = 0L
  }
}
