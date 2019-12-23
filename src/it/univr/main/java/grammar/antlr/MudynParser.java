// Generated from Mudyn.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__29=1, T__28=2, T__27=3, T__26=4, T__25=5, T__24=6, T__23=7, T__22=8, 
		T__21=9, T__20=10, T__19=11, T__18=12, T__17=13, T__16=14, T__15=15, T__14=16, 
		T__13=17, T__12=18, T__11=19, T__10=20, T__9=21, T__8=22, T__7=23, T__6=24, 
		T__5=25, T__4=26, T__3=27, T__2=28, T__1=29, T__0=30, BOOL=31, ID=32, 
		INT=33, STRING=34, WS=35;
	public static final String[] tokenNames = {
		"<INVALID>", "'{'", "'while'", "';'", "'||'", "'&&'", "'}'", "'='", "'if'", 
		"'new Number('", "'num('", "'('", "'*'", "','", "'eval('", "'new String('", 
		"'length('", "'skip'", "'<'", "'=='", "'concat('", "'>'", "'new Boolean('", 
		"'!'", "'indexOf('", "'.charAt('", "'else'", "')'", "'substring('", "'+'", 
		"'-'", "BOOL", "ID", "INT", "STRING", "WS"
	};
	public static final int
		RULE_dimp = 0, RULE_exp = 1, RULE_comm = 2, RULE_block = 3;
	public static final String[] ruleNames = {
		"dimp", "exp", "comm", "block"
	};

	@Override
	public String getGrammarFileName() { return "Mudyn.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public TerminalNode EOF() { return getToken(MudynParser.EOF, 0); }
		public CommContext comm() {
			return getRuleContext(CommContext.class,0);
		}
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
			setState(8); comm(0);
			setState(9); match(EOF);
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
			setState(62);
			switch (_input.LA(1)) {
			case T__7:
				{
				_localctx = new NegationContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(12); match(T__7);
				setState(13); exp(10);
				}
				break;
			case ID:
				{
				_localctx = new IdNameContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(14); match(ID);
				}
				break;
			case T__19:
				{
				_localctx = new ParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15); match(T__19);
				setState(16); exp(0);
				setState(17); match(T__3);
				}
				break;
			case INT:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19); match(INT);
				}
				break;
			case T__14:
				{
				_localctx = new LenStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20); match(T__14);
				setState(21); exp(0);
				setState(22); match(T__3);
				}
				break;
			case T__20:
				{
				_localctx = new CastStringToIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24); match(T__20);
				setState(25); exp(0);
				setState(26); match(T__3);
				}
				break;
			case T__21:
				{
				_localctx = new ObjectNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(28); match(T__21);
				setState(29); exp(0);
				setState(30); match(T__3);
				}
				break;
			case T__6:
				{
				_localctx = new IndexOfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(32); match(T__6);
				setState(33); exp(0);
				setState(34); match(T__17);
				setState(35); exp(0);
				setState(36); match(T__3);
				}
				break;
			case BOOL:
				{
				_localctx = new BooleansContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(38); match(BOOL);
				}
				break;
			case T__8:
				{
				_localctx = new ObjectBooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39); match(T__8);
				setState(40); exp(0);
				setState(41); match(T__3);
				}
				break;
			case STRING:
				{
				_localctx = new StringGenericContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43); match(STRING);
				}
				break;
			case T__10:
				{
				_localctx = new ConcatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(44); match(T__10);
				setState(45); exp(0);
				setState(46); match(T__17);
				setState(47); exp(0);
				setState(48); match(T__3);
				}
				break;
			case T__2:
				{
				_localctx = new SubstringsContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(50); match(T__2);
				setState(51); exp(0);
				setState(52); match(T__17);
				setState(53); exp(0);
				setState(54); match(T__17);
				setState(55); exp(0);
				setState(56); match(T__3);
				}
				break;
			case T__15:
				{
				_localctx = new ObjectStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(58); match(T__15);
				setState(59); exp(0);
				setState(60); match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(93);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new SumContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(64);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(65); match(T__1);
						setState(66); exp(19);
						}
						break;
					case 2:
						{
						_localctx = new SotContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(67);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(68); match(T__0);
						setState(69); exp(18);
						}
						break;
					case 3:
						{
						_localctx = new MolContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(70);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(71); match(T__18);
						setState(72); exp(17);
						}
						break;
					case 4:
						{
						_localctx = new LogicAndContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(73);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(74); match(T__25);
						setState(75); exp(13);
						}
						break;
					case 5:
						{
						_localctx = new LogicOrContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(76);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(77); match(T__26);
						setState(78); exp(12);
						}
						break;
					case 6:
						{
						_localctx = new EqualExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(79);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(80); match(T__11);
						setState(81); exp(9);
						}
						break;
					case 7:
						{
						_localctx = new GreaterExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(82);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(83); match(T__9);
						setState(84); exp(8);
						}
						break;
					case 8:
						{
						_localctx = new LessExpContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(85);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(86); match(T__12);
						setState(87); exp(7);
						}
						break;
					case 9:
						{
						_localctx = new CharAtContext(new ExpContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_exp);
						setState(88);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(89); match(T__5);
						setState(90); exp(0);
						setState(91); match(T__3);
						}
						break;
					}
					} 
				}
				setState(97);
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
		public CommContext comm(int i) {
			return getRuleContext(CommContext.class,i);
		}
		public List<CommContext> comm() {
			return getRuleContexts(CommContext.class);
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
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode ID() { return getToken(MudynParser.ID, 0); }
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
			setState(126);
			switch (_input.LA(1)) {
			case T__13:
				{
				_localctx = new SkipContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(99); match(T__13);
				setState(100); match(T__27);
				}
				break;
			case ID:
				{
				_localctx = new AssignmentStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101); match(ID);
				setState(102); match(T__23);
				setState(103); exp(0);
				setState(104); match(T__27);
				}
				break;
			case T__22:
				{
				_localctx = new IfStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106); match(T__22);
				setState(107); match(T__19);
				setState(108); exp(0);
				setState(109); match(T__3);
				setState(110); block();
				setState(111); match(T__4);
				setState(112); block();
				}
				break;
			case T__28:
				{
				_localctx = new WhileStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114); match(T__28);
				setState(115); match(T__19);
				setState(116); exp(0);
				setState(117); match(T__3);
				setState(118); block();
				}
				break;
			case T__29:
				{
				_localctx = new BlockStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120); block();
				}
				break;
			case T__16:
				{
				_localctx = new EvalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121); match(T__16);
				setState(122); exp(0);
				setState(123); match(T__3);
				setState(124); match(T__27);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(132);
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
					setState(128);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(129); comm(0);
					}
					} 
				}
				setState(134);
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
			setState(143);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135); match(T__29);
				setState(137);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(136); match(T__24);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); match(T__29);
				setState(140); comm(0);
				setState(141); match(T__24);
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
		case 1: return exp_sempred((ExpContext)_localctx, predIndex);
		case 2: return comm_sempred((CommContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean comm_sempred(CommContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean exp_sempred(ExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 18);
		case 1: return precpred(_ctx, 17);
		case 2: return precpred(_ctx, 16);
		case 3: return precpred(_ctx, 12);
		case 4: return precpred(_ctx, 11);
		case 5: return precpred(_ctx, 8);
		case 6: return precpred(_ctx, 7);
		case 7: return precpred(_ctx, 6);
		case 8: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3%\u0094\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3A\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\7\3`\n\3\f\3\16\3c\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\5\4\u0081\n\4\3\4\3\4\7\4\u0085\n\4\f\4\16\4\u0088\13\4\3\5"+
		"\3\5\5\5\u008c\n\5\3\5\3\5\3\5\3\5\5\5\u0092\n\5\3\5\2\4\4\6\6\2\4\6\b"+
		"\2\2\u00ad\2\n\3\2\2\2\4@\3\2\2\2\6\u0080\3\2\2\2\b\u0091\3\2\2\2\n\13"+
		"\5\6\4\2\13\f\7\2\2\3\f\3\3\2\2\2\r\16\b\3\1\2\16\17\7\31\2\2\17A\5\4"+
		"\3\f\20A\7\"\2\2\21\22\7\r\2\2\22\23\5\4\3\2\23\24\7\35\2\2\24A\3\2\2"+
		"\2\25A\7#\2\2\26\27\7\22\2\2\27\30\5\4\3\2\30\31\7\35\2\2\31A\3\2\2\2"+
		"\32\33\7\f\2\2\33\34\5\4\3\2\34\35\7\35\2\2\35A\3\2\2\2\36\37\7\13\2\2"+
		"\37 \5\4\3\2 !\7\35\2\2!A\3\2\2\2\"#\7\32\2\2#$\5\4\3\2$%\7\17\2\2%&\5"+
		"\4\3\2&\'\7\35\2\2\'A\3\2\2\2(A\7!\2\2)*\7\30\2\2*+\5\4\3\2+,\7\35\2\2"+
		",A\3\2\2\2-A\7$\2\2./\7\26\2\2/\60\5\4\3\2\60\61\7\17\2\2\61\62\5\4\3"+
		"\2\62\63\7\35\2\2\63A\3\2\2\2\64\65\7\36\2\2\65\66\5\4\3\2\66\67\7\17"+
		"\2\2\678\5\4\3\289\7\17\2\29:\5\4\3\2:;\7\35\2\2;A\3\2\2\2<=\7\21\2\2"+
		"=>\5\4\3\2>?\7\35\2\2?A\3\2\2\2@\r\3\2\2\2@\20\3\2\2\2@\21\3\2\2\2@\25"+
		"\3\2\2\2@\26\3\2\2\2@\32\3\2\2\2@\36\3\2\2\2@\"\3\2\2\2@(\3\2\2\2@)\3"+
		"\2\2\2@-\3\2\2\2@.\3\2\2\2@\64\3\2\2\2@<\3\2\2\2Aa\3\2\2\2BC\f\24\2\2"+
		"CD\7\37\2\2D`\5\4\3\25EF\f\23\2\2FG\7 \2\2G`\5\4\3\24HI\f\22\2\2IJ\7\16"+
		"\2\2J`\5\4\3\23KL\f\16\2\2LM\7\7\2\2M`\5\4\3\17NO\f\r\2\2OP\7\6\2\2P`"+
		"\5\4\3\16QR\f\n\2\2RS\7\25\2\2S`\5\4\3\13TU\f\t\2\2UV\7\27\2\2V`\5\4\3"+
		"\nWX\f\b\2\2XY\7\24\2\2Y`\5\4\3\tZ[\f\3\2\2[\\\7\33\2\2\\]\5\4\3\2]^\7"+
		"\35\2\2^`\3\2\2\2_B\3\2\2\2_E\3\2\2\2_H\3\2\2\2_K\3\2\2\2_N\3\2\2\2_Q"+
		"\3\2\2\2_T\3\2\2\2_W\3\2\2\2_Z\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2b"+
		"\5\3\2\2\2ca\3\2\2\2de\b\4\1\2ef\7\23\2\2f\u0081\7\5\2\2gh\7\"\2\2hi\7"+
		"\t\2\2ij\5\4\3\2jk\7\5\2\2k\u0081\3\2\2\2lm\7\n\2\2mn\7\r\2\2no\5\4\3"+
		"\2op\7\35\2\2pq\5\b\5\2qr\7\34\2\2rs\5\b\5\2s\u0081\3\2\2\2tu\7\4\2\2"+
		"uv\7\r\2\2vw\5\4\3\2wx\7\35\2\2xy\5\b\5\2y\u0081\3\2\2\2z\u0081\5\b\5"+
		"\2{|\7\20\2\2|}\5\4\3\2}~\7\35\2\2~\177\7\5\2\2\177\u0081\3\2\2\2\u0080"+
		"d\3\2\2\2\u0080g\3\2\2\2\u0080l\3\2\2\2\u0080t\3\2\2\2\u0080z\3\2\2\2"+
		"\u0080{\3\2\2\2\u0081\u0086\3\2\2\2\u0082\u0083\f\4\2\2\u0083\u0085\5"+
		"\6\4\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\7\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b\7\3\2\2"+
		"\u008a\u008c\7\b\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0092"+
		"\3\2\2\2\u008d\u008e\7\3\2\2\u008e\u008f\5\6\4\2\u008f\u0090\7\b\2\2\u0090"+
		"\u0092\3\2\2\2\u0091\u0089\3\2\2\2\u0091\u008d\3\2\2\2\u0092\t\3\2\2\2"+
		"\t@_a\u0080\u0086\u008b\u0091";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}