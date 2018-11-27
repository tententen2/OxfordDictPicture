package com.jirawatpoo.remote.model
import com.google.gson.annotations.SerializedName

data class DataDictDetailRemote(
    @SerializedName("metadata")
    val metadata: Metadata,
    @SerializedName("results")
    val results: List<Result>
)

data class Metadata(
    @SerializedName("provider")
    val provider: String // Oxford University Press
)

data class Result(
    @SerializedName("id")
    val id: String, // ace
    @SerializedName("language")
    val language: String, // en
    @SerializedName("lexicalEntries")
    val lexicalEntries: List<LexicalEntry>,
    @SerializedName("type")
    val type: String, // headword
    @SerializedName("word")
    val word: String // ace
)

data class LexicalEntry(
    @SerializedName("entries")
    val entries: List<Entry>,
    @SerializedName("language")
    val language: String, // en
    @SerializedName("lexicalCategory")
    val lexicalCategory: String, // Residual
    @SerializedName("pronunciations")
    val pronunciations: List<Pronunciation>,
    @SerializedName("text")
    val text: String // ACE
)

data class Entry(
    @SerializedName("grammaticalFeatures")
    val grammaticalFeatures: List<GrammaticalFeature>,
    @SerializedName("homographNumber")
    val homographNumber: String, // 600
    @SerializedName("senses")
    val senses: List<Sense>
)

data class GrammaticalFeature(
    @SerializedName("text")
    val text: String, // Abbreviation
    @SerializedName("type")
    val type: String // Residual
)

data class Sense(
    @SerializedName("definitions")
    val definitions: List<String>,
    @SerializedName("domains")
    val domains: List<String>,
    @SerializedName("id")
    val id: String, // m_en_gbus0005690.002
    @SerializedName("regions")
    val regions: List<String>,
    @SerializedName("short_definitions")
    val shortDefinitions: List<String>
)

data class Pronunciation(
    @SerializedName("audioFile")
    val audioFile: String, // http://audio.oxforddictionaries.com/en/mp3/ace_1_us_1_abbr.mp3
    @SerializedName("dialects")
    val dialects: List<String>,
    @SerializedName("phoneticNotation")
    val phoneticNotation: String, // respell
    @SerializedName("phoneticSpelling")
    val phoneticSpelling: String // ās
)