// Generated from Prefix.g4 by ANTLR 4.7
package ru.ifmo;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PrefixParser}.
 */
public interface PrefixListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PrefixParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(PrefixParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(PrefixParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PrefixParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PrefixParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(PrefixParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(PrefixParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(PrefixParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(PrefixParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void enterIfExpr(PrefixParser.IfExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#ifExpr}.
	 * @param ctx the parse tree
	 */
	void exitIfExpr(PrefixParser.IfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#elseExpr}.
	 * @param ctx the parse tree
	 */
	void enterElseExpr(PrefixParser.ElseExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#elseExpr}.
	 * @param ctx the parse tree
	 */
	void exitElseExpr(PrefixParser.ElseExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(PrefixParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(PrefixParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(PrefixParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(PrefixParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(PrefixParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#arithmeticExpr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(PrefixParser.ArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PrefixParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicExpr(PrefixParser.LogicExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PrefixParser#logicExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicExpr(PrefixParser.LogicExprContext ctx);
}