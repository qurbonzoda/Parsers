/*
 * [The "BSD license"]
 *  Copyright (c) 2012-2014 Terence Parr
 *  Copyright (c) 2012-2014 Sam Harwell
 *  Copyright (c) 2015 Gerald Rosenberg
 *  All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions
 *  are met:
 *
 *  1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *  3. The name of the author may not be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 *  IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 *  OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 *  IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 *  INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 *  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 *  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 *  THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 *  THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
/*	A grammar for ANTLR v4 written in ANTLR v4.
 *
 *	Modified 2015.06.16 gbr
 *	-- update for compatibility with Antlr v4.5
 *	-- add mode for channels
 *	-- moved members to LexerAdaptor
 * 	-- move fragments to imports
 */

parser grammar ANTLRv4Parser;

options
   { tokenVocab = ANTLRv4Lexer; }

@parser::header {
package antlr_g4;
}

// The main entry point for parsing a v4 grammar.
grammarSpec
   : DOC_COMMENT* grammarType identifier SEMI rules modeSpec* EOF
   ;

grammarType
   : (LEXER GRAMMAR | PARSER GRAMMAR | GRAMMAR)
   ;


// ------------


actionBlock
   : BEGIN_ACTION ACTION_CONTENT* END_ACTION
   ;

argActionBlock
   : BEGIN_ARGUMENT ARGUMENT_CONTENT* END_ARGUMENT
   ;

modeSpec
   : MODE identifier SEMI lexerRuleSpec*
   ;

rules
   : ruleSpec*
   ;

ruleSpec
   : parserRuleSpec
   | lexerRuleSpec
   ;

parserRuleSpec
   : DOC_COMMENT* RULE_REF argActionBlock? ruleReturns? localsSpec? COLON ruleAltList SEMI
   ;

ruleReturns
   : RETURNS argActionBlock
   ;

// --------------
localsSpec
   : LOCALS argActionBlock
   ;

// An individual access modifier for a rule. The 'fragment' modifier
// is an internal indication for lexer rules that they do not match
// from the input but are like subroutines for other lexer rules to
// reuse for certain lexical patterns. The other modifiers are passed
// to the code generation templates and may be ignored by the template
// if they are of no use in that language.


ruleAltList
   : alternative (OR alternative)*
   ;

// --------------------
// Lexer rules
lexerRuleSpec
   : DOC_COMMENT* FRAGMENT? TOKEN_REF COLON lexerAltList SEMI
   ;

lexerAltList
   : lexerAlt (OR lexerAlt)*
   ;

lexerAlt
   : lexerElements
   |
   // explicitly allow empty alts
   ;

lexerElements
   : lexerElement +
   ;

lexerElement
   : lexerAtom
   ;

// --------------------
// Rule Alts

alternative
   : element +
   |
   // explicitly allow empty alts
   ;

element
   : labeledElement
   | atom
   | actionBlock
   ;

labeledElement
   : identifier ASSIGN atom
   ;

// --------------------

lexerAtom
   : characterRange
   | terminal
   | LEXER_CHAR_SET
   ;

atom
   : terminal
   | ruleref
   ;

// ----------------
// Parser rule ref
ruleref
   : RULE_REF argActionBlock?
   ;

// ---------------
// Character Range
characterRange
   : STRING_LITERAL RANGE STRING_LITERAL
   ;

terminal
   : TOKEN_REF
   | STRING_LITERAL
   ;

identifier
   : RULE_REF
   | TOKEN_REF
   ;