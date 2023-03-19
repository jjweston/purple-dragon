# Purple Dragon

Experiment with language-driven programming.

## Under Development

**This version of Purple Dragon is under development and may not be stable or work correctly.**

## Overview

Purple Dragon is intended to provide tools to assist with the following tasks:

- Create Custom Programming Languages
- Create Parsers
- Create Interpreters
- Manage Parse Tree Data Structures
- Translate Code from One Language to Another

## Purple Dragon Language

File Extension: `.pdl`

### Element

An *Element* is either `null` or one of three types: *String*, *Byte Array*, or *Node*.

<pre>
<i>Element:</i>
  <i>(one of)</i>
  null <i>String</i> <i>ByteArray</i> <i>Node</i>
</pre>

### String

A *String* is an ordered collection of Unicode characters.

<pre>
<i>String:</i>
  " <i>{StringCharacter}</i> "

<i>StringCharacter:</i>
  <i>any Unicode character, but not ", \, CR, or LF</i>
  <i>StringEscape</i>

<i>StringEscape</i>
  \ t <i>(horizontal tab, HT)</i>
  \ n <i>(linefeed, LF)</i>
  \ r <i>(carriage return, CR)</i>
  \ " <i>(double quote, ")</i>
  \ \ <i>(backslash, \)</i>
</pre>

### Byte Array

A *Byte Array* is an ordered collection of bytes.

<pre>
<i>ByteArray:</i>
  &lt; <i>{Byte}</i> &gt;

<i>Byte:</i>
  <i>HexDigit</i> <i>HexDigit</i>

<i>HexDigit:</i>
  <i>(one of)</i>
  0 1 2 3 4 5 6 7 8 9 a b c d e f A B C D E F
</pre>

### Node

A *Node* is an ordered collection of attributes.
Each attribute is a name/value pair.
The name and value are both *Elements*.
Duplicate names are permitted.

<pre>
<i>Node:</i>
  { <i>{NodeAttribute}</i> }

<i>NodeAttribute:</i>
  <i>Element</i> <i>Element</i>
</pre>
