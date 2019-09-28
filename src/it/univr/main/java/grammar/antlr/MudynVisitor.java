// Generated from Mudyn.g4 by ANTLR 4.7.2

package grammar.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MudynParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MudynVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ProgramExecution}
	 * labeled alternative in {@link MudynParser#dimp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramExecution(MudynParser.ProgramExecutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicOr}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicOr(MudynParser.LogicOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Substrings}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstrings(MudynParser.SubstringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterExp(MudynParser.GreaterExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectNumber}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectNumber(MudynParser.ObjectNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Negation}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(MudynParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringGeneric}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringGeneric(MudynParser.StringGenericContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexOf}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexOf(MudynParser.IndexOfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectBoolean}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectBoolean(MudynParser.ObjectBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Booleans}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleans(MudynParser.BooleansContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualExp(MudynParser.EqualExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LenString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLenString(MudynParser.LenStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(MudynParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mol}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMol(MudynParser.MolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Int}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(MudynParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Concat}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcat(MudynParser.ConcatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdName}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdName(MudynParser.IdNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parenthesis}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(MudynParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CastStringToInt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCastStringToInt(MudynParser.CastStringToIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CharAt}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharAt(MudynParser.CharAtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectString}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectString(MudynParser.ObjectStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessExp}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessExp(MudynParser.LessExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sot}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSot(MudynParser.SotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicAnd}
	 * labeled alternative in {@link MudynParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicAnd(MudynParser.LogicAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Composition}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComposition(MudynParser.CompositionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(MudynParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(MudynParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStmt(MudynParser.BlockStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Skip}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSkip(MudynParser.SkipContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentStmt}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(MudynParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Eval}
	 * labeled alternative in {@link MudynParser#comm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEval(MudynParser.EvalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MudynParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MudynParser.BlockContext ctx);
}