// Generated from Mudyn.g4 by ANTLR 4.4

package grammar.antlr;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MudynParser}.
 */
public interface MudynListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Substrings}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSubstrings(@NotNull MudynParser.SubstringsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Substrings}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSubstrings(@NotNull MudynParser.SubstringsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GreaterExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterGreaterExp(@NotNull MudynParser.GreaterExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GreaterExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitGreaterExp(@NotNull MudynParser.GreaterExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterNegation(@NotNull MudynParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitNegation(@NotNull MudynParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringGeneric}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterStringGeneric(@NotNull MudynParser.StringGenericContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringGeneric}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitStringGeneric(@NotNull MudynParser.StringGenericContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Booleans}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterBooleans(@NotNull MudynParser.BooleansContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Booleans}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitBooleans(@NotNull MudynParser.BooleansContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterInt(@NotNull MudynParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitInt(@NotNull MudynParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterConcat(@NotNull MudynParser.ConcatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitConcat(@NotNull MudynParser.ConcatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdName}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIdName(@NotNull MudynParser.IdNameContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdName}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIdName(@NotNull MudynParser.IdNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(@NotNull MudynParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(@NotNull MudynParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CastStringToInt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCastStringToInt(@NotNull MudynParser.CastStringToIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CastStringToInt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCastStringToInt(@NotNull MudynParser.CastStringToIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(@NotNull MudynParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(@NotNull MudynParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LessExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLessExp(@NotNull MudynParser.LessExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LessExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLessExp(@NotNull MudynParser.LessExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link MudynParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull MudynParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MudynParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull MudynParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLogicAnd(@NotNull MudynParser.LogicAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLogicAnd(@NotNull MudynParser.LogicAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Eval}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull MudynParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Eval}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull MudynParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLogicOr(@NotNull MudynParser.LogicOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLogicOr(@NotNull MudynParser.LogicOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterComposition(@NotNull MudynParser.CompositionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitComposition(@NotNull MudynParser.CompositionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectNumber}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectNumber(@NotNull MudynParser.ObjectNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectNumber}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectNumber(@NotNull MudynParser.ObjectNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterIndexOf(@NotNull MudynParser.IndexOfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitIndexOf(@NotNull MudynParser.IndexOfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectBoolean}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectBoolean(@NotNull MudynParser.ObjectBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectBoolean}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectBoolean(@NotNull MudynParser.ObjectBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterBlockStmt(@NotNull MudynParser.BlockStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitBlockStmt(@NotNull MudynParser.BlockStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterEqualExp(@NotNull MudynParser.EqualExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitEqualExp(@NotNull MudynParser.EqualExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LenString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLenString(@NotNull MudynParser.LenStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LenString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLenString(@NotNull MudynParser.LenStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSum(@NotNull MudynParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSum(@NotNull MudynParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mol}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMol(@NotNull MudynParser.MolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mol}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMol(@NotNull MudynParser.MolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(@NotNull MudynParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(@NotNull MudynParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MudynParser#dimp}.
	 * @param ctx the parse tree
	 */
	void enterProgramExecution(@NotNull MudynParser.ProgramExecutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MudynParser#dimp}.
	 * @param ctx the parse tree
	 */
	void exitProgramExecution(@NotNull MudynParser.ProgramExecutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterCharAt(@NotNull MudynParser.CharAtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitCharAt(@NotNull MudynParser.CharAtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterObjectString(@NotNull MudynParser.ObjectStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitObjectString(@NotNull MudynParser.ObjectStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterSkip(@NotNull MudynParser.SkipContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitSkip(@NotNull MudynParser.SkipContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sot}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSot(@NotNull MudynParser.SotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sot}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSot(@NotNull MudynParser.SotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(@NotNull MudynParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(@NotNull MudynParser.AssignmentStmtContext ctx);
}