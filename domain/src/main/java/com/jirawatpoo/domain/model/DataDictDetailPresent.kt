package com.jirawatpoo.domain.model

data class DataDictDetailPresent(
        val metadata: Metadata,
        val results: List<Result>
)

data class Metadata(
    val provider: String // Oxford University Press
)

data class Result(
        val id: String, // ace
        val language: String, // en
        val lexicalEntries: List<LexicalEntry>,
        val type: String, // headword
        val word: String // ace
)

data class LexicalEntry(
        val entries: List<Entry>,
        val language: String, // en
        val lexicalCategory: String, // Residual
        val pronunciations: List<Pronunciation>,
        val text: String // ACE
)

data class Entry(
        val grammaticalFeatures: List<GrammaticalFeature>,
        val homographNumber: String, // 600
        val senses: List<Sense>
)

data class GrammaticalFeature(
    val text: String, // Abbreviation
    val type: String // Residual
)

data class Sense(
    val definitions: List<String>,
    val domains: List<String>,
    val id: String, // m_en_gbus0005690.002
    val regions: List<String>,
    val shortDefinitions: List<String>
)

data class Pronunciation(
    val audioFile: String, // http://audio.oxforddictionaries.com/en/mp3/ace_1_us_1_abbr.mp3
    val dialects: List<String>,
    val phoneticNotation: String, // respell
    val phoneticSpelling: String // ās
)