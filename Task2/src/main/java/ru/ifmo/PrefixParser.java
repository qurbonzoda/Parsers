// Generated from Prefix.g4 by ANTLR 4.7
package ru.ifmo;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PrefixParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, Number=19, Bool=20, VarName=21, WS=22;
	public static final int
		RULE_start = 0, RULE_program = 1, RULE_action = 2, RULE_conditional = 3, 
		RULE_ifExpr = 4, RULE_elseExpr = 5, RULE_assign = 6, RULE_print = 7, RULE_arithmeticExpr = 8, 
		RULE_logicExpr = 9;
	public static final String[] ruleNames = {
		"start", "program", "action", "conditional", "ifExpr", "elseExpr", "assign", 
		"print", "arithmeticExpr", "logicExpr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'if'", "'elif'", "'else'", "'='", "'print'", "'+'", "'-'", "'*'", 
		"'/'", "'and'", "'or'", "'not'", "'<'", "'>'", "'>='", "'<='", "'=='", 
		"'!='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, "Number", "Bool", "VarName", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Prefix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PrefixParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public String value;
		public ProgramContext p;
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			((StartContext)_localctx).p = program();
			((StartContext)_localctx).value =  String.format("begin%s\nend.", ((StartContext)_localctx).p.value);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public String value = "";
		public ActionContext act;
		public List<ActionContext> action() {
			return getRuleContexts(ActionContext.class);
		}
		public ActionContext action(int i) {
			return getRuleContext(ActionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__3) | (1L << T__4))) != 0)) {
				{
				{
				setState(23);
				((ProgramContext)_localctx).act = action();
				_localctx.value += String.format("\n%s", ((ProgramContext)_localctx).act.value);
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public String value = "\t";
		public AssignContext a;
		public PrintContext p;
		public ConditionalContext e;
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ConditionalContext conditional() {
			return getRuleContext(ConditionalContext.class,0);
		}
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_action);
		try {
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				((ActionContext)_localctx).a = assign();
				_localctx.value += ((ActionContext)_localctx).a.value;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				((ActionContext)_localctx).p = print();
				_localctx.value += ((ActionContext)_localctx).p.value;
				}
				break;
			case T__0:
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				((ActionContext)_localctx).e = conditional();
				_localctx.value += ((ActionContext)_localctx).e.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionalContext extends ParserRuleContext {
		public String value;
		public IfExprContext i;
		public ElseExprContext e;
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public ElseExprContext elseExpr() {
			return getRuleContext(ElseExprContext.class,0);
		}
		public ConditionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterConditional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitConditional(this);
		}
	}

	public final ConditionalContext conditional() throws RecognitionException {
		ConditionalContext _localctx = new ConditionalContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_conditional);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				((ConditionalContext)_localctx).i = ifExpr();
				((ConditionalContext)_localctx).value =  ((ConditionalContext)_localctx).i.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				((ConditionalContext)_localctx).i = ifExpr();
				setState(46);
				((ConditionalContext)_localctx).e = elseExpr();
				((ConditionalContext)_localctx).value =  ((ConditionalContext)_localctx).i.value + "\n" + ((ConditionalContext)_localctx).e.value;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfExprContext extends ParserRuleContext {
		public String value;
		public LogicExprContext e;
		public ActionContext act;
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitIfExpr(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifExpr);
		try {
			setState(61);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				match(T__0);
				setState(52);
				((IfExprContext)_localctx).e = logicExpr();
				setState(53);
				((IfExprContext)_localctx).act = action();
				((IfExprContext)_localctx).value =  String.format("if (%s) then\n\t%s", ((IfExprContext)_localctx).e.value, ((IfExprContext)_localctx).act.value);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(T__1);
				setState(57);
				((IfExprContext)_localctx).e = logicExpr();
				setState(58);
				((IfExprContext)_localctx).act = action();
				((IfExprContext)_localctx).value =  String.format("else if (%s) then\n\t%s", ((IfExprContext)_localctx).e.value, ((IfExprContext)_localctx).act.value);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ElseExprContext extends ParserRuleContext {
		public String value;
		public ActionContext act;
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public ElseExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterElseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitElseExpr(this);
		}
	}

	public final ElseExprContext elseExpr() throws RecognitionException {
		ElseExprContext _localctx = new ElseExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_elseExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(T__2);
			setState(64);
			((ElseExprContext)_localctx).act = action();
			((ElseExprContext)_localctx).value =  String.format("else then\n\t%s", ((ElseExprContext)_localctx).act.value);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignContext extends ParserRuleContext {
		public String value;
		public Token bVar;
		public LogicExprContext le;
		public Token var;
		public ArithmeticExprContext ae;
		public TerminalNode VarName() { return getToken(PrefixParser.VarName, 0); }
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ArithmeticExprContext arithmeticExpr() {
			return getRuleContext(ArithmeticExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assign);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(T__3);
				setState(68);
				((AssignContext)_localctx).bVar = match(VarName);
				setState(69);
				((AssignContext)_localctx).le = logicExpr();
				((AssignContext)_localctx).value =  String.format("%s = %s;", (((AssignContext)_localctx).bVar!=null?((AssignContext)_localctx).bVar.getText():null), ((AssignContext)_localctx).le.value);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(T__3);
				setState(73);
				((AssignContext)_localctx).var = match(VarName);
				setState(74);
				((AssignContext)_localctx).ae = arithmeticExpr();
				((AssignContext)_localctx).value =  String.format("%s = %s;", (((AssignContext)_localctx).var!=null?((AssignContext)_localctx).var.getText():null), ((AssignContext)_localctx).ae.value);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public String value;
		public LogicExprContext le;
		public ArithmeticExprContext ae;
		public LogicExprContext logicExpr() {
			return getRuleContext(LogicExprContext.class,0);
		}
		public ArithmeticExprContext arithmeticExpr() {
			return getRuleContext(ArithmeticExprContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitPrint(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_print);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				match(T__4);
				setState(80);
				((PrintContext)_localctx).le = logicExpr();
				((PrintContext)_localctx).value =  String.format("writeln(%s);", ((PrintContext)_localctx).le.value);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(T__4);
				setState(84);
				((PrintContext)_localctx).ae = arithmeticExpr();
				((PrintContext)_localctx).value =  String.format("writeln(%s);", ((PrintContext)_localctx).ae.value);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArithmeticExprContext extends ParserRuleContext {
		public String value;
		public ArithmeticExprContext e1;
		public ArithmeticExprContext e2;
		public Token n;
		public Token var;
		public List<ArithmeticExprContext> arithmeticExpr() {
			return getRuleContexts(ArithmeticExprContext.class);
		}
		public ArithmeticExprContext arithmeticExpr(int i) {
			return getRuleContext(ArithmeticExprContext.class,i);
		}
		public TerminalNode Number() { return getToken(PrefixParser.Number, 0); }
		public TerminalNode VarName() { return getToken(PrefixParser.VarName, 0); }
		public ArithmeticExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterArithmeticExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitArithmeticExpr(this);
		}
	}

	public final ArithmeticExprContext arithmeticExpr() throws RecognitionException {
		ArithmeticExprContext _localctx = new ArithmeticExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arithmeticExpr);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__7:
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
					{
					setState(89);
					match(T__5);
					setState(90);
					((ArithmeticExprContext)_localctx).e1 = arithmeticExpr();
					setState(91);
					((ArithmeticExprContext)_localctx).e2 = arithmeticExpr();
					((ArithmeticExprContext)_localctx).value =  String.format("(%s + %s)", ((ArithmeticExprContext)_localctx).e1.value, ((ArithmeticExprContext)_localctx).e2.value);
					}
					break;
				case T__6:
					{
					setState(94);
					match(T__6);
					setState(95);
					((ArithmeticExprContext)_localctx).e1 = arithmeticExpr();
					setState(96);
					((ArithmeticExprContext)_localctx).e2 = arithmeticExpr();
					((ArithmeticExprContext)_localctx).value =  String.format("(%s - %s)", ((ArithmeticExprContext)_localctx).e1.value, ((ArithmeticExprContext)_localctx).e2.value);
					}
					break;
				case T__7:
					{
					setState(99);
					match(T__7);
					setState(100);
					((ArithmeticExprContext)_localctx).e1 = arithmeticExpr();
					setState(101);
					((ArithmeticExprContext)_localctx).e2 = arithmeticExpr();
					((ArithmeticExprContext)_localctx).value =  String.format("%s * %s", ((ArithmeticExprContext)_localctx).e1.value, ((ArithmeticExprContext)_localctx).e2.value);
					}
					break;
				case T__8:
					{
					setState(104);
					match(T__8);
					setState(105);
					((ArithmeticExprContext)_localctx).e1 = arithmeticExpr();
					setState(106);
					((ArithmeticExprContext)_localctx).e2 = arithmeticExpr();
					((ArithmeticExprContext)_localctx).value =  String.format("(%s / %s)", ((ArithmeticExprContext)_localctx).e1.value, ((ArithmeticExprContext)_localctx).e2.value);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				((ArithmeticExprContext)_localctx).n = match(Number);
				((ArithmeticExprContext)_localctx).value =  (((ArithmeticExprContext)_localctx).n!=null?((ArithmeticExprContext)_localctx).n.getText():null);
				}
				break;
			case VarName:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				((ArithmeticExprContext)_localctx).var = match(VarName);
				((ArithmeticExprContext)_localctx).value =  (((ArithmeticExprContext)_localctx).var!=null?((ArithmeticExprContext)_localctx).var.getText():null);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LogicExprContext extends ParserRuleContext {
		public String value;
		public LogicExprContext e1;
		public LogicExprContext e2;
		public LogicExprContext e;
		public Token b;
		public ArithmeticExprContext ae1;
		public ArithmeticExprContext ae2;
		public List<LogicExprContext> logicExpr() {
			return getRuleContexts(LogicExprContext.class);
		}
		public LogicExprContext logicExpr(int i) {
			return getRuleContext(LogicExprContext.class,i);
		}
		public TerminalNode Bool() { return getToken(PrefixParser.Bool, 0); }
		public TerminalNode VarName() { return getToken(PrefixParser.VarName, 0); }
		public List<ArithmeticExprContext> arithmeticExpr() {
			return getRuleContexts(ArithmeticExprContext.class);
		}
		public ArithmeticExprContext arithmeticExpr(int i) {
			return getRuleContext(ArithmeticExprContext.class,i);
		}
		public LogicExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).enterLogicExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PrefixListener ) ((PrefixListener)listener).exitLogicExpr(this);
		}
	}

	public final LogicExprContext logicExpr() throws RecognitionException {
		LogicExprContext _localctx = new LogicExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logicExpr);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__9:
					{
					setState(117);
					match(T__9);
					setState(118);
					((LogicExprContext)_localctx).e1 = logicExpr();
					setState(119);
					((LogicExprContext)_localctx).e2 = logicExpr();
					((LogicExprContext)_localctx).value =  String.format("%s and %s", ((LogicExprContext)_localctx).e1.value, ((LogicExprContext)_localctx).e2.value);
					}
					break;
				case T__10:
					{
					setState(122);
					match(T__10);
					setState(123);
					((LogicExprContext)_localctx).e1 = logicExpr();
					setState(124);
					((LogicExprContext)_localctx).e2 = logicExpr();
					((LogicExprContext)_localctx).value =  String.format("(%s or %s)", ((LogicExprContext)_localctx).e1.value, ((LogicExprContext)_localctx).e2.value);
					}
					break;
				case T__11:
					{
					setState(127);
					match(T__11);
					setState(128);
					((LogicExprContext)_localctx).e = logicExpr();
					((LogicExprContext)_localctx).value =  String.format("not %s", ((LogicExprContext)_localctx).e.value);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case Bool:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				((LogicExprContext)_localctx).b = match(Bool);
				((LogicExprContext)_localctx).value =  (((LogicExprContext)_localctx).b!=null?((LogicExprContext)_localctx).b.getText():null);
				}
				break;
			case VarName:
				enterOuterAlt(_localctx, 3);
				{
				setState(135);
				((LogicExprContext)_localctx).b = match(VarName);
				((LogicExprContext)_localctx).value =  (((LogicExprContext)_localctx).b!=null?((LogicExprContext)_localctx).b.getText():null);
				}
				break;
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(177);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(137);
					match(T__12);
					setState(138);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(139);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s < %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 2:
					{
					setState(142);
					match(T__13);
					setState(143);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(144);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s > %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 3:
					{
					setState(147);
					match(T__14);
					setState(148);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(149);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s >= %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 4:
					{
					setState(152);
					match(T__15);
					setState(153);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(154);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s <= %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 5:
					{
					setState(157);
					match(T__16);
					setState(158);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(159);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s == %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 6:
					{
					setState(162);
					match(T__16);
					setState(163);
					((LogicExprContext)_localctx).e1 = logicExpr();
					setState(164);
					((LogicExprContext)_localctx).e2 = logicExpr();
					((LogicExprContext)_localctx).value =  String.format("%s == %s", ((LogicExprContext)_localctx).e1.value, ((LogicExprContext)_localctx).e2.value);
					}
					break;
				case 7:
					{
					setState(167);
					match(T__17);
					setState(168);
					((LogicExprContext)_localctx).ae1 = arithmeticExpr();
					setState(169);
					((LogicExprContext)_localctx).ae2 = arithmeticExpr();
					((LogicExprContext)_localctx).value =  String.format("%s != %s", ((LogicExprContext)_localctx).ae1.value, ((LogicExprContext)_localctx).ae2.value);
					}
					break;
				case 8:
					{
					setState(172);
					match(T__17);
					setState(173);
					((LogicExprContext)_localctx).e1 = logicExpr();
					setState(174);
					((LogicExprContext)_localctx).e2 = logicExpr();
					((LogicExprContext)_localctx).value =  String.format("%s != %s", ((LogicExprContext)_localctx).e1.value, ((LogicExprContext)_localctx).e2.value);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u00b8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4+\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\64\n\5"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6@\n\6\3\7\3\7\3\7\3\7\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bP\n\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\tZ\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3\n\3\n\3\n\3\n\5\nv\n\n\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u0086"+
		"\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\5\13\u00b4\n\13\5\13\u00b6\n\13\3\13\2\2\f\2\4\6\b\n\f"+
		"\16\20\22\24\2\2\2\u00c5\2\26\3\2\2\2\4\36\3\2\2\2\6*\3\2\2\2\b\63\3\2"+
		"\2\2\n?\3\2\2\2\fA\3\2\2\2\16O\3\2\2\2\20Y\3\2\2\2\22u\3\2\2\2\24\u00b5"+
		"\3\2\2\2\26\27\5\4\3\2\27\30\b\2\1\2\30\3\3\2\2\2\31\32\5\6\4\2\32\33"+
		"\b\3\1\2\33\35\3\2\2\2\34\31\3\2\2\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3"+
		"\2\2\2\37\5\3\2\2\2 \36\3\2\2\2!\"\5\16\b\2\"#\b\4\1\2#+\3\2\2\2$%\5\20"+
		"\t\2%&\b\4\1\2&+\3\2\2\2\'(\5\b\5\2()\b\4\1\2)+\3\2\2\2*!\3\2\2\2*$\3"+
		"\2\2\2*\'\3\2\2\2+\7\3\2\2\2,-\5\n\6\2-.\b\5\1\2.\64\3\2\2\2/\60\5\n\6"+
		"\2\60\61\5\f\7\2\61\62\b\5\1\2\62\64\3\2\2\2\63,\3\2\2\2\63/\3\2\2\2\64"+
		"\t\3\2\2\2\65\66\7\3\2\2\66\67\5\24\13\2\678\5\6\4\289\b\6\1\29@\3\2\2"+
		"\2:;\7\4\2\2;<\5\24\13\2<=\5\6\4\2=>\b\6\1\2>@\3\2\2\2?\65\3\2\2\2?:\3"+
		"\2\2\2@\13\3\2\2\2AB\7\5\2\2BC\5\6\4\2CD\b\7\1\2D\r\3\2\2\2EF\7\6\2\2"+
		"FG\7\27\2\2GH\5\24\13\2HI\b\b\1\2IP\3\2\2\2JK\7\6\2\2KL\7\27\2\2LM\5\22"+
		"\n\2MN\b\b\1\2NP\3\2\2\2OE\3\2\2\2OJ\3\2\2\2P\17\3\2\2\2QR\7\7\2\2RS\5"+
		"\24\13\2ST\b\t\1\2TZ\3\2\2\2UV\7\7\2\2VW\5\22\n\2WX\b\t\1\2XZ\3\2\2\2"+
		"YQ\3\2\2\2YU\3\2\2\2Z\21\3\2\2\2[\\\7\b\2\2\\]\5\22\n\2]^\5\22\n\2^_\b"+
		"\n\1\2_p\3\2\2\2`a\7\t\2\2ab\5\22\n\2bc\5\22\n\2cd\b\n\1\2dp\3\2\2\2e"+
		"f\7\n\2\2fg\5\22\n\2gh\5\22\n\2hi\b\n\1\2ip\3\2\2\2jk\7\13\2\2kl\5\22"+
		"\n\2lm\5\22\n\2mn\b\n\1\2np\3\2\2\2o[\3\2\2\2o`\3\2\2\2oe\3\2\2\2oj\3"+
		"\2\2\2pv\3\2\2\2qr\7\25\2\2rv\b\n\1\2st\7\27\2\2tv\b\n\1\2uo\3\2\2\2u"+
		"q\3\2\2\2us\3\2\2\2v\23\3\2\2\2wx\7\f\2\2xy\5\24\13\2yz\5\24\13\2z{\b"+
		"\13\1\2{\u0086\3\2\2\2|}\7\r\2\2}~\5\24\13\2~\177\5\24\13\2\177\u0080"+
		"\b\13\1\2\u0080\u0086\3\2\2\2\u0081\u0082\7\16\2\2\u0082\u0083\5\24\13"+
		"\2\u0083\u0084\b\13\1\2\u0084\u0086\3\2\2\2\u0085w\3\2\2\2\u0085|\3\2"+
		"\2\2\u0085\u0081\3\2\2\2\u0086\u00b6\3\2\2\2\u0087\u0088\7\26\2\2\u0088"+
		"\u00b6\b\13\1\2\u0089\u008a\7\27\2\2\u008a\u00b6\b\13\1\2\u008b\u008c"+
		"\7\17\2\2\u008c\u008d\5\22\n\2\u008d\u008e\5\22\n\2\u008e\u008f\b\13\1"+
		"\2\u008f\u00b4\3\2\2\2\u0090\u0091\7\20\2\2\u0091\u0092\5\22\n\2\u0092"+
		"\u0093\5\22\n\2\u0093\u0094\b\13\1\2\u0094\u00b4\3\2\2\2\u0095\u0096\7"+
		"\21\2\2\u0096\u0097\5\22\n\2\u0097\u0098\5\22\n\2\u0098\u0099\b\13\1\2"+
		"\u0099\u00b4\3\2\2\2\u009a\u009b\7\22\2\2\u009b\u009c\5\22\n\2\u009c\u009d"+
		"\5\22\n\2\u009d\u009e\b\13\1\2\u009e\u00b4\3\2\2\2\u009f\u00a0\7\23\2"+
		"\2\u00a0\u00a1\5\22\n\2\u00a1\u00a2\5\22\n\2\u00a2\u00a3\b\13\1\2\u00a3"+
		"\u00b4\3\2\2\2\u00a4\u00a5\7\23\2\2\u00a5\u00a6\5\24\13\2\u00a6\u00a7"+
		"\5\24\13\2\u00a7\u00a8\b\13\1\2\u00a8\u00b4\3\2\2\2\u00a9\u00aa\7\24\2"+
		"\2\u00aa\u00ab\5\22\n\2\u00ab\u00ac\5\22\n\2\u00ac\u00ad\b\13\1\2\u00ad"+
		"\u00b4\3\2\2\2\u00ae\u00af\7\24\2\2\u00af\u00b0\5\24\13\2\u00b0\u00b1"+
		"\5\24\13\2\u00b1\u00b2\b\13\1\2\u00b2\u00b4\3\2\2\2\u00b3\u008b\3\2\2"+
		"\2\u00b3\u0090\3\2\2\2\u00b3\u0095\3\2\2\2\u00b3\u009a\3\2\2\2\u00b3\u009f"+
		"\3\2\2\2\u00b3\u00a4\3\2\2\2\u00b3\u00a9\3\2\2\2\u00b3\u00ae\3\2\2\2\u00b4"+
		"\u00b6\3\2\2\2\u00b5\u0085\3\2\2\2\u00b5\u0087\3\2\2\2\u00b5\u0089\3\2"+
		"\2\2\u00b5\u00b3\3\2\2\2\u00b6\25\3\2\2\2\r\36*\63?OYou\u0085\u00b3\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}