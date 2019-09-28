// Generated from Mudyn.g4 by ANTLR 4.7.2

package grammar.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MudynParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, BOOL=31, ID=32, 
		INT=33, STRING=34, WS=35;
	public static final int
		RULE_dimp = 0, RULE_exp = 1, RULE_comm = 2, RULE_block = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"dimp", "exp", "comm", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'len('", "'num('", "'+'", "'-'", "'*'", "'new Number('", 
			"'.indexOf('", "'&&'", "'||'", "'!'", "'new Boolean('", "'=='", "'>'", 
			"'<'", "'.'", "'substring('", "','", "'new String('", "'.charAt('", "'skip'", 
			"';'", "'='", "'if'", "'else'", "'while'", "'eval('", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "BOOL", "ID", "INT", "STRING", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Mudyn.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MudynParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DimpContext extends ParserRuleContext {
		public DimpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimp; }
	 
		public DimpContext() { }
		public void copyFrom(DimpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramExecutionContext extends DimpContext {
		public CommContext comm() {
			return getRuleContext(CommContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MudynParser.EOF, 0); }
		public ProgramExecutionContext(DimpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterProgramExecution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitProgramExecution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitProgramExecution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimpContext dimp() throws RecognitionException {
		DimpContext _localctx = new DimpContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dimp);
		try {
			_localctx = new ProgramExecutionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			comm(0);
			setState(9);
			match(EOF);
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

	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LogicOrContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LogicOrContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterLogicOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitLogicOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitLogicOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubstringsContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SubstringsContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterSubstrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitSubstrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitSubstrings(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public GreaterExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterGreaterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitGreaterExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitGreaterExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectNumberContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ObjectNumberContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterObjectNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitObjectNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitObjectNumber(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegationContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public NegationContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterNegation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitNegation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringGenericContext extends ExpContext {
		public TerminalNode STRING() { return getToken(MudynParser.STRING, 0); }
		public StringGenericContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterStringGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitStringGeneric(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitStringGeneric(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexOfContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public IndexOfContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterIndexOf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitIndexOf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitIndexOf(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectBooleanContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ObjectBooleanContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterObjectBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitObjectBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitObjectBoolean(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleansContext extends ExpContext {
		public TerminalNode BOOL() { return getToken(MudynParser.BOOL, 0); }
		public BooleansContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterBooleans(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitBooleans(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitBooleans(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqualExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public EqualExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterEqualExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitEqualExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitEqualExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LenStringContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public LenStringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterLenString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitLenString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitLenString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SumContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SumContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MolContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public MolContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterMol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitMol(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitMol(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntContext extends ExpContext {
		public TerminalNode INT() { return getToken(MudynParser.INT, 0); }
		public IntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConcatContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public ConcatContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterConcat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitConcat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitConcat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdNameContext extends ExpContext {
		public TerminalNode ID() { return getToken(MudynParser.ID, 0); }
		public IdNameContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterIdName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitIdName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitIdName(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenthesisContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ParenthesisContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitParenthesis(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CastStringToIntContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public CastStringToIntContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterCastStringToInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitCastStringToInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitCastStringToInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CharAtContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public CharAtContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterCharAt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitCharAt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitCharAt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ObjectStringContext extends ExpContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ObjectStringContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterObjectString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitObjectString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitObjectString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessExpContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LessExpContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterLessExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitLessExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitLessExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SotContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public SotContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterSot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitSot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitSot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicAndContext extends ExpContext {
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LogicAndContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterLogicAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitLogicAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitLogicAnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		return exp(0);
	}

	private ExpContext exp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpContext _localctx = new ExpContext(_ctx, _parentState);
		ExpContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_exp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				_localctx = new IdNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(12);
				match(ID);
				}
				break;
			case T__0:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13);
				match(T__0);
				setState(14);
				exp(0);
				setState(15);
				match(T__1);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17);
				match(INT);
				}
				break;
			case T__2:
				{
				_localctx = new LenStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(18);
				match(T__2);
				setState(19);
				exp(0);
				setState(20);
				match(T__1);
				}
				break;
			case T__3:
				{
				_localctx = new CastStringToIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(22);
				match(T__3);
				setState(23);
				exp(0);
				setState(24);
				match(T__1);
				}
				break;
			case T__7:
				{
				_localctx = new ObjectNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(26);
				match(T__7);
				setState(27);
				exp(0);
				setState(28);
				match(T__1);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleansContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(BOOL);
				}
				break;
			case T__11:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(T__11);
				setState(32);
				exp(10);
				}
				break;
			case T__12:
				{
				_localctx = new ObjectBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(33);
				match(T__12);
				setState(34);
				exp(0);
				setState(35);
				match(T__1);
				}
				break;
			case STRING:
				{
				_localctx = new StringGenericContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(STRING);
				}
				break;
			case T__17:
				{
				_localctx = new SubstringsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38);
				match(T__17);
				setState(39);
				exp(0);
				setState(40);
				match(T__18);
				setState(41);
				exp(0);
				setState(42);
				match(T__18);
				setState(43);
				exp(0);
				setState(44);
				match(T__1);
				}
				break;
			case T__19:
				{
				_localctx = new ObjectStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(46);
				match(T__19);
				setState(47);
				exp(0);
				setState(48);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(89);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new SumContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(52);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(53);
						match(T__4);
						setState(54);
						exp(19);
						}
						break;
					case 2:
						{
						_localctx = new SotContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(55);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(56);
						match(T__5);
						setState(57);
						exp(18);
						}
						break;
					case 3:
						{
						_localctx = new MolContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(58);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(59);
						match(T__6);
						setState(60);
						exp(17);
						}
						break;
					case 4:
						{
						_localctx = new LogicAndContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(61);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(62);
						match(T__9);
						setState(63);
						exp(13);
						}
						break;
					case 5:
						{
						_localctx = new LogicOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(64);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(65);
						match(T__10);
						setState(66);
						exp(12);
						}
						break;
					case 6:
						{
						_localctx = new EqualExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(67);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(68);
						match(T__13);
						setState(69);
						exp(9);
						}
						break;
					case 7:
						{
						_localctx = new GreaterExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(70);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(71);
						match(T__14);
						setState(72);
						exp(8);
						}
						break;
					case 8:
						{
						_localctx = new LessExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(73);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(74);
						match(T__15);
						setState(75);
						exp(7);
						}
						break;
					case 9:
						{
						_localctx = new ConcatContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(76);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(77);
						match(T__16);
						setState(78);
						exp(5);
						}
						break;
					case 10:
						{
						_localctx = new IndexOfContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(79);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(80);
						match(T__8);
						setState(81);
						exp(0);
						setState(82);
						match(T__1);
						}
						break;
					case 11:
						{
						_localctx = new CharAtContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(84);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(85);
						match(T__20);
						setState(86);
						exp(0);
						setState(87);
						match(T__1);
						}
						break;
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CommContext extends ParserRuleContext {
		public CommContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comm; }
	 
		public CommContext() { }
		public void copyFrom(CommContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CompositionContext extends CommContext {
		public List<CommContext> comm() {
			return getRuleContexts(CommContext.class);
		}
		public CommContext comm(int i) {
			return getRuleContext(CommContext.class,i);
		}
		public CompositionContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterComposition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitComposition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitComposition(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtContext extends CommContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IfStmtContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtContext extends CommContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStmtContext extends CommContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStmtContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterBlockStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitBlockStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitBlockStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SkipContext extends CommContext {
		public SkipContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterSkip(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitSkip(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitSkip(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignmentStmtContext extends CommContext {
		public TerminalNode ID() { return getToken(MudynParser.ID, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignmentStmtContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterAssignmentStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitAssignmentStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitAssignmentStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EvalContext extends CommContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public EvalContext(CommContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommContext comm() throws RecognitionException {
		return comm(0);
	}

	private CommContext comm(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CommContext _localctx = new CommContext(_ctx, _parentState);
		CommContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_comm, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				{
				_localctx = new SkipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(95);
				match(T__21);
				setState(96);
				match(T__22);
				}
				break;
			case ID:
				{
				_localctx = new AssignmentStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				match(ID);
				setState(98);
				match(T__23);
				setState(99);
				exp(0);
				setState(100);
				match(T__22);
				}
				break;
			case T__24:
				{
				_localctx = new IfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102);
				match(T__24);
				setState(103);
				match(T__0);
				setState(104);
				exp(0);
				setState(105);
				match(T__1);
				setState(106);
				block();
				setState(107);
				match(T__25);
				setState(108);
				block();
				}
				break;
			case T__26:
				{
				_localctx = new WhileStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(T__26);
				setState(111);
				match(T__0);
				setState(112);
				exp(0);
				setState(113);
				match(T__1);
				setState(114);
				block();
				}
				break;
			case T__28:
				{
				_localctx = new BlockStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116);
				block();
				}
				break;
			case T__27:
				{
				_localctx = new EvalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(117);
				match(T__27);
				setState(118);
				exp(0);
				setState(119);
				match(T__1);
				setState(120);
				match(T__22);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(128);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CompositionContext(new CommContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_comm);
					setState(124);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(125);
					comm(3);
					}
					} 
				}
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public CommContext comm() {
			return getRuleContext(CommContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MudynListener ) ((MudynListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MudynVisitor ) return ((MudynVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		try {
			setState(139);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(T__28);
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(132);
					match(T__29);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(T__28);
				setState(136);
				comm(0);
				setState(137);
				match(T__29);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return exp_sempred((ExpContext)_localctx, predIndex);
		case 2:
			return comm_sempred((CommContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 14);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean comm_sempred(CommContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0090\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\65\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\7\3\\\n\3\f\3\16\3_\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4}\n\4\3\4\3\4\7\4\u0081\n\4\f\4\16\4\u0084\13\4\3\5\3\5\5\5\u0088\n"+
		"\5\3\5\3\5\3\5\3\5\5\5\u008e\n\5\3\5\2\4\4\6\6\2\4\6\b\2\2\2\u00a9\2\n"+
		"\3\2\2\2\4\64\3\2\2\2\6|\3\2\2\2\b\u008d\3\2\2\2\n\13\5\6\4\2\13\f\7\2"+
		"\2\3\f\3\3\2\2\2\r\16\b\3\1\2\16\65\7\"\2\2\17\20\7\3\2\2\20\21\5\4\3"+
		"\2\21\22\7\4\2\2\22\65\3\2\2\2\23\65\7#\2\2\24\25\7\5\2\2\25\26\5\4\3"+
		"\2\26\27\7\4\2\2\27\65\3\2\2\2\30\31\7\6\2\2\31\32\5\4\3\2\32\33\7\4\2"+
		"\2\33\65\3\2\2\2\34\35\7\n\2\2\35\36\5\4\3\2\36\37\7\4\2\2\37\65\3\2\2"+
		"\2 \65\7!\2\2!\"\7\16\2\2\"\65\5\4\3\f#$\7\17\2\2$%\5\4\3\2%&\7\4\2\2"+
		"&\65\3\2\2\2\'\65\7$\2\2()\7\24\2\2)*\5\4\3\2*+\7\25\2\2+,\5\4\3\2,-\7"+
		"\25\2\2-.\5\4\3\2./\7\4\2\2/\65\3\2\2\2\60\61\7\26\2\2\61\62\5\4\3\2\62"+
		"\63\7\4\2\2\63\65\3\2\2\2\64\r\3\2\2\2\64\17\3\2\2\2\64\23\3\2\2\2\64"+
		"\24\3\2\2\2\64\30\3\2\2\2\64\34\3\2\2\2\64 \3\2\2\2\64!\3\2\2\2\64#\3"+
		"\2\2\2\64\'\3\2\2\2\64(\3\2\2\2\64\60\3\2\2\2\65]\3\2\2\2\66\67\f\24\2"+
		"\2\678\7\7\2\28\\\5\4\3\259:\f\23\2\2:;\7\b\2\2;\\\5\4\3\24<=\f\22\2\2"+
		"=>\7\t\2\2>\\\5\4\3\23?@\f\16\2\2@A\7\f\2\2A\\\5\4\3\17BC\f\r\2\2CD\7"+
		"\r\2\2D\\\5\4\3\16EF\f\n\2\2FG\7\20\2\2G\\\5\4\3\13HI\f\t\2\2IJ\7\21\2"+
		"\2J\\\5\4\3\nKL\f\b\2\2LM\7\22\2\2M\\\5\4\3\tNO\f\6\2\2OP\7\23\2\2P\\"+
		"\5\4\3\7QR\f\20\2\2RS\7\13\2\2ST\5\4\3\2TU\7\4\2\2U\\\3\2\2\2VW\f\3\2"+
		"\2WX\7\27\2\2XY\5\4\3\2YZ\7\4\2\2Z\\\3\2\2\2[\66\3\2\2\2[9\3\2\2\2[<\3"+
		"\2\2\2[?\3\2\2\2[B\3\2\2\2[E\3\2\2\2[H\3\2\2\2[K\3\2\2\2[N\3\2\2\2[Q\3"+
		"\2\2\2[V\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\5\3\2\2\2_]\3\2\2\2`"+
		"a\b\4\1\2ab\7\30\2\2b}\7\31\2\2cd\7\"\2\2de\7\32\2\2ef\5\4\3\2fg\7\31"+
		"\2\2g}\3\2\2\2hi\7\33\2\2ij\7\3\2\2jk\5\4\3\2kl\7\4\2\2lm\5\b\5\2mn\7"+
		"\34\2\2no\5\b\5\2o}\3\2\2\2pq\7\35\2\2qr\7\3\2\2rs\5\4\3\2st\7\4\2\2t"+
		"u\5\b\5\2u}\3\2\2\2v}\5\b\5\2wx\7\36\2\2xy\5\4\3\2yz\7\4\2\2z{\7\31\2"+
		"\2{}\3\2\2\2|`\3\2\2\2|c\3\2\2\2|h\3\2\2\2|p\3\2\2\2|v\3\2\2\2|w\3\2\2"+
		"\2}\u0082\3\2\2\2~\177\f\4\2\2\177\u0081\5\6\4\5\u0080~\3\2\2\2\u0081"+
		"\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\7\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0085\u0087\7\37\2\2\u0086\u0088\7 \2\2\u0087\u0086"+
		"\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008e\3\2\2\2\u0089\u008a\7\37\2\2"+
		"\u008a\u008b\5\6\4\2\u008b\u008c\7 \2\2\u008c\u008e\3\2\2\2\u008d\u0085"+
		"\3\2\2\2\u008d\u0089\3\2\2\2\u008e\t\3\2\2\2\t\64[]|\u0082\u0087\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}